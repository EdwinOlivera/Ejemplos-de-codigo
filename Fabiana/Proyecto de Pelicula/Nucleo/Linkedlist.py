
# Nodo recibe todos los atributos de la pelicula
class Node:
    def __init__(self, No, titulo, director, categoria, descripcion, duracion):
        self.next        = None
        self.No          = No
        self.titulo      = titulo
        self.director    = director
        self.categoria   = categoria
        self.descripcion = descripcion
        self.duracion    = duracion

class LinkedList: 
    def __init__(self):
        self.first = None

    def Add(self, nodo): #Metodo para agregar en la linkedlist
        if(not self.first):
            self.first = nodo
            return True
        else:
            current = self.first
            while(current.next):
                current = current.next
            current.next= nodo
            return True
        return False
    

    def LinkedToStr(self,current):  #Metodo para generar una cadena que representa la lista.
        trail = ""          # Se inicializa la variable que se retornara y mientras exista un actual
        while(current):
            trail = "%s%s" %(trail, str(current.No)+","+current.titulo+","+current.categoria+","+current.director+","+current.descripcion+ ","+current.duracion+ "\n") #Se concatenan los valores en la lista.
            current = current.next #Muevo la lista
        return trail #retorno la cadena
        
    def LinkedToCsv(self,filename):   #Metodo que convierte la linkedlist en un archivo csv.
        current = self.first  # Inicializo la lista en el primero.
        csvStr = self.LinkedToStr(current) #Llamo la funcion para convertir en cadena.
        f = open(filename,"w") #Abre el archivo para escribir 
        f.write(csvStr) #Se escribe lo extraido de la linkedlist
        f.close() #Se cierra el archivo
        return True

    def RemoveForPosition(self,n):# Metodo que recibe un parametro y remueve en la posicion recibida
        if(n>-1):
            current=self.first
            if(n==0):
                self.first=current.next
                return True
            else:
                count=0
                while(current.next):
                    before=current
                    current=current.next
                    count +=1
                    if(count==n):
                        before.next=current.next
                        return True
                return False
        return False


    def LinkedListLength(self): #Metodo calcula el tamaño de la lista
        if(not self.first):
            return 0
        else:
            count=1
            current= self.first
            while(current.next):
                current=current.next
                count+=1
            return count

    def FileToLinkedlist(self, fileName):#Metodo que lee el archivo y agrega en la linkedlist
        f= open(fileName, "r")
        for linea in f:
            if(linea!=""):
                lista =linea.strip().split(",")
                nodo= Node(lista[0],lista[1],lista[3],lista[2],lista[4], lista[5])
                self.Add(nodo)
            else: 
                pass
        f.close()

    def Search(self, pos): #Metodo que busca segun posicion en la linkedlist y retorna el nodo con cada valor
        if(pos>-1):
            current=self.first
            if(pos==0):
                return current.titulo, current.categoria, current.director, current.descripcion, current.duracion
            else:
                count=0
                while(current.next):
                    before=current
                    current=current.next
                    count +=1
                    if(count==pos):
                        return current.titulo, current.categoria, current.director, current.descripcion, current.duracion
                return False
        return False

    def Edit(self, pos, nodo): #Metodo que edita segun posicion recibida 
        count=0
        if(pos==0):
            queue=self.first.next
            self.first= Node(nodo[0], nodo[1],nodo[2], nodo[3],nodo[4])
            self.first.next= queue
        else:
            if(pos>0):
                current= self.first
                while(current.next):
                    current=current.next
                    count= count + 1
                    if(pos==count):
                        queue = current.next
                        current.next= Node(nodo[0],nodo[1],nodo[2],nodo[3],nodo[4], nodo[5])
                        self.RemoveForPosition(pos)
                        current.next.next= queue
                        return True
        return False
        
                    


