# -*- coding: utf-8-*-
import sys,shutil,re,os
from PyQt5 import QtWidgets
from PyQt5 import uic
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5 import QtGui
from PyQt5.QtWidgets import (QApplication, QDialog,
                             QProgressBar, QPushButton, QLabel)
from PyQt5.QtCore import QTimer
from NUCLEO.cifrado import *
from NUCLEO.CSV import *
from NUCLEO.Linkedlist import *
from timeit import default_timer



# Instancia de la clase linkedlist
listaC = LinkedList()
# Desde archivo de memoria convertir a linkedlist
listaC.FileToLinkedlist("NUCLEO/Contrasenias.csv")


#Clase donde se inicializa el programa para que se ejecute la pantalla principal
class load:
    def __init__(self):
        pass
        self.csv = CSV("NUCLEO/Contrasenias.csv")

    def load(self):
        app = QtWidgets.QApplication(sys.argv)
        window = MainWindows()
        window.show()
        sys.exit(app.exec_())
#Inici la ventana Principal
class MainWindows(QtWidgets.QMainWindow):  
    def __init__(self):
        super(MainWindows, self).__init__()
        #Instancia de la clase de cifrado
        self.initial_work_directory = os.getcwd()
        self.Cifrado = Encrypt()
        self.txt_Contasenia = QtWidgets.QTextEdit(self)
        self.txt_RutaOrigen = QtWidgets.QTextEdit(self)
        self.txt_RutaDestino = QtWidgets.QTextEdit(self)
        QtWidgets.QMainWindow.__init__(self)
        uic.loadUi("NUCLEO/MainWindow.ui",self)

        #Intanca del boton "Acerca de" 
        self.acerca = AcercaDe()

        #Definicendo Tituto
        self.setWindowTitle("Encriptador/Desencriptador")

        # Boton que cierra el formulario principal
        self.btn_Salir.clicked.connect(self.close)
       
        #Boton que abre ventana "Acerca De"
        self.btn_AcesrcaDe.clicked.connect(self.about)
        #Boton que abre la ventana "Seleccionar" RO
        self.btn_SeleccionarArchivo.clicked.connect(self.ventanaSelect)

        #Boton que abre la ventana "Seleccionar" RD
        self.btn_SeleccionarDestino.clicked.connect(self.ventanaSelect1)

        #Boton de Ejecutar encriptado
        self.btn_EjecutarEncriptado.clicked.connect(self.encriptacion)

        #Boton de Ejecutar Desencriptado
        self.btn_EjecutarDesencriptdo.clicked.connect(self.desencriptacion)


        
    #Metodo ventana "Acerca De"
    def about(self):
        self.acerca.exec()

    def encriptacion(self):

        password = self.txt_Contasenia.toPlainText()
        print(password)
        pathO = self.txt_RutaOrigen.toPlainText()
        print(pathO)
        pathD = self.txt_RutaDestino.toPlainText()
        print(pathD)
        if(len(password)!=0 and len(pathO)!=0 and len(pathD)!=0):
            TiempoDeEjecucionTotal = ''

            #Desgloce de ruta de Destino
            var = self.txt_RutaDestino.toPlainText()
            arregloUnido = re.split( r'[/]', var)
            print(arregloUnido)
            direccionUnida = "AES_256/OWNAlgorithm/"
            for item in range(1,len(arregloUnido)):
                direccionUnida += arregloUnido[item] + "/"
            print("La direccion final es: "+direccionUnida)

            #Desgloce de ruta de Origen
            varO = self.txt_RutaOrigen.toPlainText()
            arregloUnidoO = re.split( r'[/]', varO)
            print(arregloUnidoO)
            NombreArchivo = arregloUnidoO[len(arregloUnidoO)-1] #Esto recoge el nombre del archivo.
            print("1) El nombre del archivo es: "+ NombreArchivo) 
            direccionUnidaO = "AES_256/OWNAlgorithm/"
            for item in range(1,len(arregloUnidoO)):
                direccionUnidaO += arregloUnidoO[item] + "/"
            print("La direccion final es: "+direccionUnidaO)        
            
            #Organiza el espacio de trabajo actual
            dir_path = os.chdir(self.initial_work_directory)
            os.getcwd()

            tInicio = default_timer()
            #Recoge sumatorias de propiedades de archivos
            cantidadArchivos = listaC.LinkedListLength() + 1
            tiempoTotal = listaC.LinkedTimeSum()
            tamañoTotal = listaC.LinkedTotalTamaño()
            #Ejecuta el metodo encrypt
            TiempoDeEjecucionTotal = self.Cifrado.Main(password,pathO,tInicio,cantidadArchivos,tiempoTotal,tamañoTotal,'E')
            tamanioFile = str(os.path.getsize(pathO))

            self.clickAddMethod(NombreArchivo, TiempoDeEjecucionTotal, tamanioFile)

            dir_path = os.chdir(self.txt_RutaDestino.toPlainText())
            os.getcwd()

            #Crea las carpetas
            os.makedirs(direccionUnida, exist_ok=True)
            pathO += ".enc"
            shutil.move(pathO ,direccionUnida) #Mueve un archivo a una ruta de destino

            #Limpia los campos de text
            self.txt_RutaOrigen.setText("")
            self.txt_Contasenia.setText("")
            self.txt_RutaDestino.setText("")
        else:
            print("Hay campos de texto vacios")        


    def desencriptacion(self):
        
        password = self.txt_Contasenia.toPlainText()
        print(password)
        pathO = self.txt_RutaOrigen.toPlainText()
        print(pathO)
        pathD = self.txt_RutaDestino.toPlainText()
        print(pathD)
        if(len(password)!=0 and len(pathO)!=0 and len(pathD)!=0):
            
            #Desgloce de ruta de Destino
            var = self.txt_RutaDestino.toPlainText()
            arregloUnido = re.split( r'[/]', var)
            print(arregloUnido)
            direccionUnida = "DESC_AES_256/OWNAlgorithm/"
            for item in range(1,len(arregloUnido)):
                direccionUnida += arregloUnido[item] + "/"
            print("La direccion final es: "+direccionUnida)

            #Desgloce de ruta de Origen
            varO = self.txt_RutaOrigen.toPlainText()
            arregloUnidoO = re.split( r'[/]', varO)
            print(arregloUnidoO)
            NombreArchivo = arregloUnidoO[len(arregloUnidoO)-1] #Esto recoge el nombre del archivo.
            print("2) El nombre del archivo es: "+ NombreArchivo) 
            direccionUnidaO = "AES_256/OWNAlgorithm/"
            for item in range(1,len(arregloUnidoO)):
                direccionUnidaO += arregloUnidoO[item] + "/"
            print("La direccion final es: "+direccionUnidaO)        

            if(self.VerificarDATOS(password, NombreArchivo)):
                
                #Organiza el espacio de trabajo actual
                dir_path = os.chdir(self.txt_RutaDestino.toPlainText())
                os.getcwd()

                tInicio = default_timer()
                #Recoge sumatorias de propiedades de archivos
                cantidadArchivos = listaC.LinkedListLength()
                tiempoTotal = listaC.LinkedTimeSum()
                tamañoTotal = listaC.LinkedTotalTamaño()
                #Ejecuta el metodo encrypt
                self.Cifrado.Main(password,pathO,tInicio,cantidadArchivos,tiempoTotal,tamañoTotal,'D')

                dir_path = os.chdir(self.txt_RutaDestino.toPlainText())
                os.getcwd()

                #Crea las carpetas
                os.makedirs(direccionUnida, exist_ok=True)
                pathO = pathO[:(len(pathO) - 4)]
                print("La ruta resultante de origen es: "+pathO)
                shutil.move(pathO , direccionUnida)
                
                #Limpia los campos de text
                self.txt_RutaOrigen.setText("")
                self.txt_Contasenia.setText("")
                self.txt_RutaDestino.setText("")
            else:
                print("Contraseña invalida")
                self.txt_Contasenia.setText("Contraseña invalida")
        else:
            print("Hay campos de texto vacios")

    def ventanaSelect(self):
        self.openDialog()
        
        #Abre la ruta de origen
    def openDialog(self):   

        filename = QtWidgets.QFileDialog.getOpenFileName()
        path = filename[0]
        print(path)
        self.txt_RutaOrigen.setText(path)

        """if(len(path) !=0):
            with open(path, "r") as f:
                print(f.readline())
            self.txt_RutaOrigen.setText(path)
        else:
            print("La direccion esta vacia")"""

    def ventanaSelect1(self): 
        self.openDialog1()

        #Abre la ruta de destino
    def openDialog1(self):

        directorio = QtWidgets.QFileDialog.getExistingDirectory()
        path = directorio
        print(path)
        if(len(path) !=0):
            self.txt_RutaDestino.setText(path)
        else:
            print("La direccion esta vacia")

    def closeEvent(self,event):
        #Cuadro de dialogo antes de cerrar la ventana
        result = QtWidgets.QMessageBox.question(self,"Salir","¿Seguro qué desea salir de la aplicación?",QtWidgets.QMessageBox.Yes | QtWidgets.QMessageBox.No)
        if result == QtWidgets.QMessageBox.Yes: event.accept()
        else: event.ignore()

    # Mètodo que agrega a la linkedlist
    def clickAddMethod(self, NombreArchivo, tiempo, tamaño):
        NombreArchivo = NombreArchivo +".enc"
        count = listaC.LinkedListLength()
        mvrutaOrigen = self.txt_RutaOrigen.toPlainText()
        mvrutaDestino = self.txt_RutaDestino.toPlainText()
        mvClave = self.txt_Contasenia.toPlainText()
        
        # Validaciòn para evitar campos vacios, sino van vacios agrega
        if(len(mvrutaOrigen) != 0 and len(mvrutaDestino) != 0 and len(mvClave) != 0):
            node = Node(count, mvrutaOrigen, mvrutaDestino, mvClave, NombreArchivo, tiempo, tamaño)
            listaC.Add(node)
            listaC.LinkedToCsv("MEMORIA//Contrasenias.csv")
        else:
            self.fmMessage("¡Llene Espacios!")
    
    #Funcion para verificar que los datos sean correctos al momento de Desencriptar
    def VerificarDATOS(self, passWord, NomArchivo):
        return listaC.ComprobarDatos(passWord,NomArchivo)

    # Crea ventana del mensaje
    def fmMessage(self, sMessage):
        msg = QtWidgets.QMessageBox()
        msg.setWindowTitle("¡Exito!")
        msg.setIcon(QtWidgets.QMessageBox.Information)
        msg.setText(sMessage)
        #msg.setInformativeText(sInformation)
        msg.setStandardButtons(QtWidgets.QMessageBox.Ok)
        msg.exec_()        
          

class AcercaDe(QtWidgets.QDialog):
    def __init__(self):
        QtWidgets.QDialog.__init__(self)
        uic.loadUi("NUCLEO/About.ui",self)

        
            
if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    sys.exit(app.exec_())

