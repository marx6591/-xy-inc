#  Instruções para execução e testes da aplicação

# Softwares utilizados no projeto:
#
## Eclipse IDE for java EE Developers
## WildFly 10.1.0.final
## MySql 5.7.18

# Integrando Server Wildfly
#
## Dentro do Eclipse entre na parte de "Server Runtime Enviroment" em Preferencias e Server
## Instale o Servidor "JBoss AS, Wildfly, & EAP Server Tools" que está dentro do "Red Hat Jboss Middleware"
## Após baixar todos pacotes necessários, Reinicie o Eclipse
## Após reiniciado, volte na parte "Server Runtime Enviroment"
## Adicione o servidor "WildFly 10.x Runtime" que está dentro do "JBoss Community" com as seguintes configurações:
#### Indique o diretório onde o servidor foi baixado
#### No Runtime JRE selecione Execution Environment com o JavaSE-1.8 / JDK8
###### Caso não tenha o JDK8 na parte de "installed JRES" faça a configuração no ECLIPSE para se integrar com o JDK
##### JDK utilizado foi o 'jdk1.8.0_131'
## Na parte "New Server" selecione o "WildFly 10.x" e finalize a instalação do servidor
#
# 
# Integrando com o Banco de Dados
#
# Descompacte o Arquivo que está neste diretório com o nome de "mysql.rar"
# Copie a pasta mysql e cole no diretório ...\wildfly-10.1.0.Final\modules\system\layers\base\com
# Descompacte o Arquivo que está neste diretório com o nome de "standalone.rar"
# Copie a pasta mysql e cole no diretório ...\wildfly-10.1.0.Final\standalone\configuration
# No MySql, crie um novo Database com o nome 'mysql-xy'
# No MySql, crie um novo Usuário com o nome 'user' e a senha 1234, com todos privilégios do Database criado
# Dentro do Database 'mysql-xy' crie uma tabela chamada 'pois' com 4 colunas
# (id int(11) PK)
# (coordenadaX int(11))
# (coordenaday int(11))
# (nome varchar(255))

# Testes da Aplicação
#
# entre no endereço 'http://localhost:8080/ProjectXY/index.jsp'
#
## Teste de Cadastro do sistema
## Selecione a opção 'Cadastrar ponto de interesse'
## Entre com os dados: (Escola, 30, 30) e salve
## Volte na tela inicial e selecione a opção Listar Todos Pontos de Interesse
## Verifique se o Ponto Cadastrado está na Lista
### No Cadastro é feito a validação do formulário por javascript, para testar deixe um espaço em branco
#
## Teste da Consulta por Proximidade
## Selecione a opção 'Listar Pontos de interesse por proximidade'
## Entre com os dados: (20, 10 ,10) e busque
## Na tela verifique se os dados estão corretos e se estão corretamente apresentados
### No Cadastro é feito a validação do formulário por javascript, para testar deixe um espaço em branco
