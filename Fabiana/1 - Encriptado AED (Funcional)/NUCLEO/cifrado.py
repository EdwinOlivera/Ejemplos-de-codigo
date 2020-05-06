import os
from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto import Random

import sys,shutil,re,os
from PyQt5 import QtWidgets
from PyQt5 import uic
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5 import QtGui
from PyQt5.QtWidgets import (QApplication, QDialog,
                             QProgressBar, QPushButton, QLabel)
from PyQt5.QtCore import QTimer
from NUCLEO.table import *
from timeit import default_timer
from NUCLEO.Linkedlist import *



#from NUCLEO.PerformanceMetric import *

# from mainWindow import BarraProgreso

class Encrypt:
	def __init__(self): #
		#Instancia de la barra de progreso
		self.barrarProgreso = wait1()
		pass

	
	def encrypt(self,key,filename, TimeStart):
		chunksize = 64*1024
		outputFile = filename + ".enc"
		filesize = str(os.path.getsize(filename)).zfill(16)
		IV = Random.new().read(16)
		encryptor = AES.new(key, AES.MODE_CBC, IV)
		print("Continua el proceso")
		with open(filename, 'rb') as infile:
			with open(outputFile, 'wb') as outfile:
				outfile.write(filesize.encode('utf-8'))
				outfile.write(IV)
				
				while True:
					chunk = infile.read(chunksize)
					
					if len(chunk) == 0:
						break
					elif len(chunk) % 16 != 0:
						chunk += b' ' * (16 - (len(chunk) % 16))

					outfile.write(encryptor.encrypt(chunk))

		#Ejecuta la barra progreso
		self.barrarProgreso.InciarCuenta()
		self.barrarProgreso.exec()



	def decrypt(self,key,filename, TimeStart):
		# self.Table = tableWidget("Desencriptar")
		
		chunksize = 64*1024
		outputFile = filename[:(len(filename) - 4)]
		
		with open(filename, 'rb') as infile:
			filesize = int(infile.read(16))
			IV = infile.read(16)
			decryptor = AES.new(key, AES.MODE_CBC, IV)
			with open(outputFile, 'wb') as outfile:
				while True:
					chunk = infile.read(chunksize)
					if len(chunk) == 0:
						break
					outfile.write(decryptor.decrypt(chunk))
				outfile.truncate(filesize)
		#Ejecuta la barra progreso
		self.barrarProgreso.InciarCuenta()
		self.barrarProgreso.exec()
	


	def getKey(self,password):
		hasher = SHA256.new(password.encode('utf-8'))
		return hasher.digest()
#METODO QUE INCIA TODAS LAS OPERACIONES
	def Main(self, password, filename,TimeStart,cantidadArchivos,tiempoTotal,tamañoTotal, choice):
		tempTranscurrido = ""
		if choice == 'E':
			self.encrypt(self.getKey(password), filename, TimeStart)
			tempTranscurrido = self.AsignarDatosTablas(filename, TimeStart,cantidadArchivos,tiempoTotal,tamañoTotal, choice)
		elif choice == 'D':
			self.decrypt(self.getKey(password), filename, TimeStart)
			tempTranscurrido = self.AsignarDatosTablas(filename, TimeStart,cantidadArchivos,tiempoTotal,tamañoTotal,choice)
		else:
			print("Ninguna opcion seleccionada, cerrando...")
		#Retorna el tiempo transcurrido de toda la operacion
		return tempTranscurrido



	def AsignarDatosTablas(self, filename, TimeStart, cantidadArchivos,tiempoTotal,tamañoTotal, choice):
		
		fin = default_timer()
		arregloUnidoO = re.split( r'[/]', filename)
		NombreArchivo = arregloUnidoO[len(arregloUnidoO)-1] 
		timeExecution=str(round(fin-TimeStart,2))
		EnKilobyte = os.path.getsize(filename)/1000
		tamanio = str(EnKilobyte) + " KB"
		if(choice == "E"):
			self.Table = tableWidget("Encriptar")
		else:
			self.Table = tableWidget("Desencriptar")
		self.Table.datosTabla1(NombreArchivo,timeExecution,tamanio)

		tiempoTotal += round(fin-TimeStart,2)
		tamañoTotal += os.path.getsize(filename)
		
		self.Table.datosTabla(cantidadArchivos,tiempoTotal,tamañoTotal)
		self.Table.exec()
		return timeExecution

class wait1(QtWidgets.QDialog):
	def __init__(self):
		QtWidgets.QDialog.__init__(self)
		
		uic.loadUi("NUCLEO/VentanaEspera1.ui",self)
		
		self.progressBar1 = QProgressBar(self)
		self.progressBar1.setGeometry(70, 80, 240, 65)
		self.progressBar1.setValue(0)

	def InciarCuenta(self):
		self.timer = QTimer()
		self.timer.timeout.connect(self.handleTimer)
		self.timer.start(100)
	
	def handleTimer(self):
		value = self.progressBar1.value()
		if value < 100:
			value = value + 4
			self.progressBar1.setValue(value)
		if value >= 100:
			self.progressBar1.setValue(0)
			self.timer.stop()
			self.close()


# if __name__ == '__main__':
# 	Instancia = Encrypt()
# 	Instancia.Main()