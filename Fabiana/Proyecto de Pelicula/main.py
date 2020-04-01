# -*- coding: utf-8 -*-
import sys

import os

from PyQt5 import QtWidgets
from Nucleo.Linkedlist import *
from Nucleo.CSV import *


from PyQt5.uic import loadUiType, loadUi

# Instancia de la clase linkedlist
l = LinkedList()
# Desde archivo de memoria convertir a linkedlist
l.FileToLinkedlist("Memoria//catalogoDePelicula.csv")

class MyApp(QtWidgets.QMainWindow, QtWidgets.QTextEdit):
    def __init__(self):
        super(MyApp, self).__init__()
        # Aqui estoy cargando la pantalla mainGUI.ui con loadUi
        loadUi("Nucleo//mainGUI.ui", self)
        Center.center(self)
        self.csv = CSV("Memoria//catalogoDePelicula.csv")
        self.ActualizarCantidadPro()

        # Funciòn de los botones de la ventana principal
        self.btnAdd.clicked.connect(self.openWindowAdd)
        self.btnEdit.clicked.connect(self.openWindowEdit)
        self.btnProd.clicked.connect(self.openWindowBTProd)
        self.btnAbout.clicked.connect(self.openWindowAbout)
        self.btnAtras.clicked.connect(self.close)

    # Metodo que actualiza la cantidad de Peliculas en pantalla

    def ActualizarCantidadPro(self):
        return self.NumProLabel.setText(str(l.LinkedListLength()))

    # Metodo que abre la ventana de agregar

    def openWindowAdd(self):
        window = WindowAdd(self)
        window.show()
        self.ActualizarCantidadPro()

    # Metodo que abre la ventana de Editar, donde transforma la linkedlist
    # en archivo csv y lee el archivo csv para transformarlo en una tabla

    def openWindowEdit(self):
        window = WindowEdit(self)
        l.LinkedToCsv("Memoria//catalogoDePelicula.csv")
        self.csv = CSV("Memoria//catalogoDePelicula.csv")
        content = self.csv.getTable()
        window.textEdit.setPlainText(content)
        window.show()
        self.ActualizarCantidadPro()

    # Metodo que abre las ventanas de los arboles binarios

    def openWindowBTProd(self):
        window = WindowBinarioArbol(self)
        window.show()


    # Metodo que abre la ventana del acerca de
    def openWindowAbout(self):
        window = WindowAbout(self)
        window.show()
        self.ActualizarCantidadPro()

# Esta clase es la que contendra la pantalla de Agregar a Inventario
class WindowAdd(QtWidgets.QMainWindow, QtWidgets.QLineEdit):
    def __init__(self, parent=MyApp):
        super(WindowAdd, self).__init__(parent)
        loadUi("Nucleo//AddTo.ui", self)
        Center.center(self)

        # Acciones de la clase agregar
        self.btnAddProduct.clicked.connect(self.clickAddMethod)
        self.btnAtras.clicked.connect(self.close)
        self.btnCancelAP.clicked.connect(self.cancel)
        self.actualizar = MyApp()
        self.actualizar.ActualizarCantidadPro()

    # Mètodo que se utiliza para el botòn de cancelar
    def cancel(self):
        self.hide()
        w = MyApp()
        w.show()

    # Mètodo que agrega a la linkedlist
    def clickAddMethod(self):
        count = l.LinkedListLength()
        mvTitulo = self.txtTitulo.text()
        mvDirector = self.txtDirector.text()
        mvCategoria = self.slectCategoria.currentText()
        description = self.txtDescripcion.text()
        duracion = self.tmDuracion.text()

        # Validaciòn para evitar campos vacios, sino van vacios agrega
        if(len(mvTitulo) != 0 and len(mvDirector) != 0 and mvCategoria != "--Categorias--" and len(description) != 0):
            node = Node(count, mvTitulo, mvDirector,
                        mvCategoria, description, duracion)
            l.Add(node)
            l.LinkedToCsv("Memoria//catalogoDePelicula.csv")
        else:
            if(mvCategoria == "--Categorias--" and len(mvTitulo) != 0 and len(mvDirector) != 0 and len(description) != 0):
                self.fmMessage("¡sin categoria!",
                               "¡Tienes que seleccionar una categria!\t\t")
            else:
                self.fmMessage("¡Te equivocaste baboso!",
                               "¡llena los campos idio!\t\t")
            return False

        self.clickProcces()

        # Limpiando campos al agregar una nueva pelicula
        self.txtTitulo.clear()
        self.txtDirector.clear()
        self.txtDescripcion.clear()

    # Funciòn que llama a la funciòn para validar datos

    def clickProcces(self):
        if(self.btnAddProduct.hasFocus()):
            self.fmValidateDates()

     # Crea ventana del mensaje
    def fmMessage(self, sMessage, sInformation):
        msg = QtWidgets.QMessageBox()
        msg.setWindowTitle("¡Exito!")
        msg.setIcon(QtWidgets.QMessageBox.Information)
        msg.setText(sMessage)
        msg.setInformativeText(sInformation)
        msg.setStandardButtons(QtWidgets.QMessageBox.Ok)
        msg.exec_()

    # Metodo que valida los datos
    def fmValidateDates(self):

        sMessage = ""
        if(len(self.txtTitulo.text()) == 0):
            sMessage = "El titulo de la pelicula\n"
            self.txtTitulo.setFocus()
        elif(len(self.txtDirector.text()) == 0):
            if(len(sMessage) == 0):
                self.txtDirector.setFocus()
            sMessage = sMessage + "El directo de la pelicula\n"
        elif(len(self.txtDescripcion.text()) == 0):
            if(len(sMessage) == 0):
                self.txtDescripcion.setFocus()
            sMessage = sMessage + "La descripcion de la pelicula\n"
        elif(self.slectCategoria.currentText() == "--Categorias--"):
            if(len(sMessage) == 0):
                self.slectCategoria.setFocus()
            sMessage = sMessage + "La descripcion de la pelicula\n"
        elif(len(sMessage) > 0):
            sMessage = "Revise los siguientes datos:\n" + sMessage
            self.fmMessage("Faltan datos", sMessage)
            return False
        else:
            self.fmMessage("    ¡Excelente!     ",
                           "¡Pelicula registrada correctamente!\t\t")
            return True

# Clase que contiene los atributos para editar


class WindowAddEdit(QtWidgets.QMainWindow, QtWidgets.QLineEdit):
    def __init__(self, parent):
        super(WindowAddEdit, self).__init__(parent)
        loadUi("Nucleo//AddEdit.ui", self)
        Center.center(self)
        self.btnCancelAP.clicked.connect(self.cancel)

    def cancel(self):
        self.hide()
        w = MyApp()
        w.show()


# Esta clase es la que contendra la ventana de ver y editar inventario
class WindowEdit(QtWidgets.QMainWindow):
    def __init__(self, parent=WindowAddEdit):
        super(WindowEdit, self).__init__(parent)
        loadUi("Nucleo//ViewEdit.ui", self)
        Center.center(self)
        self.add = WindowAdd(self)
        self.btnAtras.clicked.connect(self.close)
        self.btnEdit.clicked.connect(self.editInventary)
        self.btnCancel.clicked.connect(self.eliminatePeliculaInv)
        self.actualizar = MyApp()
        self.actualizar.ActualizarCantidadPro()
        self.window = WindowAddEdit(self)

     # Metodo que crea ventana de confirmacion si se desea editar y si la respuesta es si entonces que cargue los datos de la pelicula a Editar
    def editInventary(self):
        if(len(self.leNumItem.text()) > 0):
            buttonReply = QtWidgets.QMessageBox.question(
                self, 'Editar', "¿Estas seguro que deseas modificar?", QtWidgets.QMessageBox.Yes | QtWidgets.QMessageBox.No, QtWidgets.QMessageBox.No)
            if buttonReply == QtWidgets.QMessageBox.Yes:
                print('Yes clicked.')
                nItem = int(self.leNumItem.text())
                if(nItem != ""):
                    self.window.show()
                    node = l.Search(nItem)
                    print(node)
                    self.window.txtTitulo.setText(node[0])
                    self.window.slectCategoria.setItemText(0, node[1])
                    self.window.txtDirector.setText(node[2])
                    self.window.txtDescripcion.setText(node[3])

                    self.window.btnAddProduct.clicked.connect(
                        self.clickEditMethod)
        else:
            QtWidgets.QMessageBox.warning(
                self, "Error", "No a ingresado ningun indice")
            return False

    # Metodo que agrega en la posicion que se desea editar

    def clickEditMethod(self):
        posE = int(self.leNumItem.text())
        mTitulo = str(self.window.txtTitulo.text())
        mDirector = self.window.txtDirector.text()
        mCategoria = self.window.slectCategoria.currentText()
        mDescripcion = self.window.txtDescripcion.text()
        mDuracion = self.window.tmDuracion.text()

        if(len(mTitulo) != 0 and len(mDirector) != 0 and mCategoria != "--Categorias--" and len(mDescripcion) != 0):
            edit = [posE, mTitulo, mDirector,
                    mCategoria, mDescripcion, mDuracion]
            l.Edit(posE, edit)
            l.LinkedToCsv("Memoria//catalogoDePelicula.csv")

        else:
            if(mCategoria == "--Categorias--" and len(mTitulo) != 0 and len(mDirector) != 0 and len(mDescripcion) != 0):
                    self.fmMessage("¡sin categoria!", "¡Tienes que seleccionar una categria!\t\t")
            else:
                self.fmMessage("¡Te equivocaste baboso!", "¡llena los campos idio!\t\t")
            return False


        # Actualiza tabla
        self.csv = CSV("Memoria//catalogoDePelicula.csv")
        content = self.csv.getTable()
        self.textEdit.setPlainText(content)
        self.clickProcces()

    # Metodos que crean mensajes si se ha editado con exito y valida que los campos esten llenos
    def clickProcces(self):
        if(self.window.btnAddProduct.hasFocus()):
            self.fmValidateDates()

    def fmMessage(self, sMessage, sInformation):
        msg = QtWidgets.QMessageBox()
        msg.setWindowTitle("¡Exito!")
        msg.setIcon(QtWidgets.QMessageBox.Information)
        msg.setText(sMessage)
        msg.setInformativeText(sInformation)
        msg.setStandardButtons(QtWidgets.QMessageBox.Ok)
        msg.exec_()

    def fmValidateDates(self):

        sMessage = ""
        if(len(self.window.txtTitulo.text()) == 0):
            sMessage = "El Titulo de la pelicula\n"
            self.window.txtTitulo.setFocus()
        elif(len(self.window.txtDirector.text()) == 0):
            if(len(sMessage) == 0):
                self.window.txtDirector.setFocus()
            sMessage = sMessage + "El costo de la pelicula\n"
        elif(len(self.window.txtDescripcion.text()) == 0):
            if(len(sMessage) == 0):
                self.window.txtDescripcion.setFocus()
            sMessage = sMessage + "La descripcion de la pelicula\n"
        elif(self.window.slectCategoria.currentText() == "--Categorias--"):
            if(len(sMessage) == 0):
                self.window.slectCategoria.setFocus()
            sMessage = sMessage + "La descripcion de la pelicula\n"
        elif(len(sMessage) > 0):
            sMessage = "Revise los siguientes datos:\n" + sMessage
            self.fmMessage("Faltan datos", sMessage)
            return True
        else:
            self.fmMessage(
                "¡Muy bien!", "¡Se ha editado con exito la Pelicula!\t\t")
            return True

    # Metodo para eliminar una Pelicula segun posiciòn
    def eliminatePeliculaInv(self):
        buttonReply = QtWidgets.QMessageBox.question(
            self, 'Eliminar', "¿Esta seguro que desea eliminar?", QtWidgets.QMessageBox.Yes | QtWidgets.QMessageBox.No, QtWidgets.QMessageBox.No)
        if buttonReply == QtWidgets.QMessageBox.Yes:
            print('Yes clicked.')
            nItem = self.leNumItem.text()
            l.RemoveForPosition(int(nItem))
            l.LinkedToCsv("Memoria//catalogoDePelicula.csv")
            self.csv = CSV("Memoria//catalogoDePelicula.csv")
            content = self.csv.getTable()
            self.textEdit.setPlainText(content)
            self.leNumItem.clear()
        else:
            print('No clicked.')

        self.show()


# Funcion que abre la ventana de arbol
class WindowBinarioArbol(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super(WindowBinarioArbol, self).__init__(parent)
        loadUi("Nucleo//UIArbol_binario.ui", self)
        Center.center(self)        
        os.system('python Nucleo/ArbolBinario.py')
        self.btnAtras.clicked.connect(self.close)



# Esta clase contiene la ventana de Acerca de
class WindowAbout(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super(WindowAbout, self).__init__(parent)
        loadUi("Nucleo//About.ui", self)
        Center.center(self)


class Center:
    # Metodo para centrar la ventana
    def center(self):
        qRect = self.frameGeometry()
        centerPoint = QtWidgets.QDesktopWidget().availableGeometry().center()
        qRect.moveCenter(centerPoint)
        self.move(qRect.topLeft())


if __name__ == "__main__":

    app = QtWidgets.QApplication([])
    main = MyApp()
    main.show()
    app.exec_()
