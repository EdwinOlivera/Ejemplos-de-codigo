from NUCLEO.Linkedlist import Node, LinkedList

class CSV:
    def __init__(self, FileName): #Lee el archivo de memoria
        self.FileName = FileName
        self.content = ""
        self.LL= LinkedList()
        f= open(FileName, "r")
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
                r+= "%s%s%s%s%s" %("\t\t\t\tContrasenias\t\t\n","-"*195 +"\n","No.\t|rutaOrigen   \t\t|rutaDestino \t\t|Clave \t\n", "-"*195 +"\n", row + "\n")
            else:
                r+= row + "\n"
        return r