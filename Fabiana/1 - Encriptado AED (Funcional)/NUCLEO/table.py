from PyQt5.QtGui import QFont, QIcon, QColor
from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import (QApplication, QDialog, QPushButton, QTableWidget,
                             QTableWidgetItem, QAbstractItemView, QHeaderView, QMenu,
                             QActionGroup, QAction, QMessageBox)



class tableWidget(QDialog):
    def __init__(self, NombreTabla=None,parent=None):
        super(tableWidget, self).__init__(parent)
        self.NombreTabla = NombreTabla
        self.setWindowTitle("Resumen")
        self.setFixedSize(740, 348)
        
        self.initUItablaSuperior(NombreTabla )
        self.initUIInferior(NombreTabla )
    

    def initUIInferior(self, NombreTabla):
        self.tabla1 = QTableWidget(self)

        # Deshabilitar edición
        self.tabla1.setEditTriggers(QAbstractItemView.NoEditTriggers)

        # Deshabilitar el comportamiento de arrastrar y soltar
        self.tabla1.setDragDropOverwriteMode(False)

        # Establecer el ajuste de palabras del texto 
        self.tabla1.setWordWrap(False)

        # Establecer el número de columnas
        self.tabla1.setColumnCount(3)

        # Establecer el número de filas
        self.tabla1.setRowCount(2)

        # Deshabilitar resaltado del texto del encabezado al seleccionar una fila
        self.tabla1.horizontalHeader().setHighlightSections(False)

        # Hacer que la última sección visible del encabezado ocupa todo el espacio disponible
        self.tabla1.horizontalHeader().setStretchLastSection(True)

        # Ocultar encabezado vertical
        self.tabla1.verticalHeader().setVisible(False)

        # Dibujar el fondo usando colores alternados
        self.tabla1.setAlternatingRowColors(True)


        nombreColumnas = ("","2- El Proceso Ejecutado: " + NombreTabla,"")


        # Establecer las etiquetas de encabezado horizontal usando etiquetas
        self.tabla1.setHorizontalHeaderLabels(nombreColumnas)
        
        # Establecer ancho de las columnas
        for indice, ancho in enumerate((230,230,230), start=0):
            self.tabla1.setColumnWidth(indice, ancho)

        self.tabla1.resize(700, 85)
        self.tabla1.move(20, 200)

    def datosTabla1(self,fileName,time,sizeFile):
        datos = [("Nombre", "Tiempo de Procesamiento", "Tamaño"),
        (fileName,time+" seg",sizeFile)]

        row = 0
        for endian in datos:
            self.tabla1.setRowCount(row + 1)
            
            idDato = QTableWidgetItem(endian[0])
            idDato.setTextAlignment(4)
            
            self.tabla1.setItem(row, 0, idDato)
            self.tabla1.setItem(row, 1, QTableWidgetItem(endian[1]))
            self.tabla1.setItem(row, 2, QTableWidgetItem(endian[2]))

            row += 1

        

    def initUItablaSuperior(self,NombreTabla):

        self.tabla = QTableWidget(self)

        # Deshabilitar edición
        self.tabla.setEditTriggers(QAbstractItemView.NoEditTriggers)

        # Deshabilitar el comportamiento de arrastrar y soltar
        self.tabla.setDragDropOverwriteMode(False)

        # Establecer el ajuste de palabras del texto 
        self.tabla.setWordWrap(False)

 
       # Establecer el número de columnas
        self.tabla.setColumnCount(2)

        # Establecer el número de filas
        self.tabla.setRowCount(3)

        # Deshabilitar resaltado del texto del encabezado al seleccionar una fila
        self.tabla.horizontalHeader().setHighlightSections(False)

        # Hacer que la última sección visible del encabezado ocupa todo el espacio disponible
        self.tabla.horizontalHeader().setStretchLastSection(True)

        # Ocultar encabezado vertical
        self.tabla.verticalHeader().setVisible(False)

        # Dibujar el fondo usando colores alternados
        self.tabla.setAlternatingRowColors(True)


        nombreColumnas = ("","1 - Datos Relevantes de: " + NombreTabla)

        # Establecer las etiquetas de encabezado horizontal usando etiquetas
        self.tabla.setHorizontalHeaderLabels(nombreColumnas)
        
        # Establecer ancho de las columnas
        for indice, ancho in enumerate((250, 300), start=0):
            self.tabla.setColumnWidth(indice, ancho)

        self.tabla.resize(700, 115)
        self.tabla.move(20, 56)


    def datosTabla(self, cantidadArchivos,tiempoTotal, tamañoTotal ):
        tiempoTotal = round(tiempoTotal,2)
        datos = [("Cantidad de Archivos Procesados", str(cantidadArchivos)),
                 ("Tiempo", str(tiempoTotal) + " seg"),
                 ("Tamaño Total", str(tamañoTotal)+" KB")]

        row = 0
        for endian in datos:
            self.tabla.setRowCount(row + 1)
            
            idDato = QTableWidgetItem(endian[0])
            idDato.setTextAlignment(4)
            
            self.tabla.setItem(row, 0, idDato)
            self.tabla.setItem(row, 1, QTableWidgetItem(endian[1]))

            row += 1

"""if __name__ == "__main__":

    import sys

    aplicacion = QApplication(sys.argv)

    fuente = QFont()
    fuente.setPointSize(10)
    aplicacion.setFont(fuente)

    ventana = tableWidget()
    ventana.show()

    sys.exit(aplicacion.exec_())"""