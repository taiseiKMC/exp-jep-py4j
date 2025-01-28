from py4j.clientserver import ClientServer, JavaParameters, PythonParameters
from py4j.java_collections import ListConverter

gateway=0

class Exp(object):
    def echo(self, ary):
        #ary = ListConverter().convert(ary, gateway._gateway_client)
        return ary


    class Java:
        implements = ["main.Exp"]

if __name__ == "__main__":
    exp = Exp()
    gateway = ClientServer(
        #java_parameters=JavaParameters(auto_convert=True),
        java_parameters=JavaParameters(),
        python_parameters=PythonParameters(),
        python_server_entry_point=exp)

