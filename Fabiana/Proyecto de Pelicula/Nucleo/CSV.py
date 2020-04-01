from Nucleo.Linkedlist import Node, LinkedList

class CSV:
    def __init__(self, fileName): #Lee el archivo de memoria
        self.fileName = fileName
        self.content = ""
        self.LL= LinkedList()
        f= open(fileName, "r")
        self.content = f.read()
        f.close()   

    def getContent(self):
        return self.content
    
    def getTable(self): #Metodo que genera la tabla a imprimir
        r= ""
        content = self.getContent()
        rows = content.split("\n")

        for i in range(len(rows)):
            row= rows[i].replace(",", "\t|\t")
            r+="-"*195 +"\n"
            if(i==0):
                r+= "%s%s%s%s%s" %("\t\t\t\tCatalogo de Peliculas\t\t\n","-"*195 +"\n","No.\t|Titulo   \t\t|Categoria \t\t|Director  \t\t|Descrepcion \t\t|Duracion\t\n", "-"*195 +"\n", row + "\n")
            else:
                r+= row + "\n"
        return r


