Diogo Gonçalves Silva ; 89348

Instalação:
    Defenir System Variables no Windows (10):
        1.In Search, search for and then select: System (Control Panel)
        2.Click the Advanced system settings link.
        3.Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
        In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. 4.Close all remaining windows by clicking OK.
        5.Reopen Command prompt window

    Instalar JDK:
        https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html

    Instalar Maven:
        https://www.baeldung.com/install-maven-on-windows-linux-mac


MavenIn5Minutes:
    https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

    1. Ver Maven Version (e verificar se está instalado)
        $mvn --version
    2. Criar Projeto (Este comando vai criar um diretório 'my-app')
        $mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
    3. Construir o projeto
        $mvn package
    4. Testar (e correr)
        $java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
    

    Notas:
        POM: "The pom.xml file is the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project in just the way you want."

        Java Version: "By default your version of Maven might use an old version of the maven-compiler-plugin that is not compatible with Java 9 or later versions. To target Java 9 or later, you should at least use version 3.6.0 of the maven-compiler-plugin and set the maven.compiler.release property to the Java release you are targetting (e.g. 9, 10, 11, 12, etc.)."

        Maven Project Phases:    
            -VALIDATE: validate the project is correct and all necessary information is available
            -COMPILE: compile the source code of the project
            -TEST: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
            -PACKAGE: take the compiled code and package it in its distributable format, such as a JAR.
            -INTEGRATION-TEST: process and deploy the package if necessary into an environment where integration tests can be run
            -VERIFY: run any checks to verify the package is valid and meets quality criteria
            -INSTALL: install the package into the local repository, for use as a dependency in other projects locally
            -DEPLOY: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

Convenções de nomenclatura:
    https://maven.apache.org/guides/mini/guide-naming-conventions.html
    
    groupID: Uniquely identifies your project across all projects. It should follow Java's package name (https://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7.7) rules. This means it starts with a reversed domain name you control. 
    
    artifactId: Its the name of the jar without version. You can choose whatever name you want with lowercase letters and no strange symbols.


Novo Projeto (WeatherRadar):
    http://api.ipma.pt/

    1. Costumizar Metadados do POM:
        POM Customization Reference: https://books.sonatype.com/mvnex-book/reference/customizing-sect-customizing-project-info.html

    2. Configurar Java Version
        Configurar Java Version no Maven (https://www.baeldung.com/maven-java-version)
            1. Check version 
                $mvn -v
            2. "Starting from JDK 9 version, we can use a new -release command-line option"
            No POM:
                <properties>
                    <maven.compiler.release>11</maven.compiler.release>

                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>3.8.1</version>
                        <configuration>
                            <release>11</release>
                        </configuration>
                    </plugin>
                </properties>

    3. Adicionar Artifacts (dependencias)
        No POM:
            <dependency>
                <groupId>com.squareup.retrofit2</groupId>
                <artifactId>retrofit</artifactId>
                <version>2.6.1</version>
            </dependency>  
            <dependency>  
                <groupId>com.squareup.retrofit2</groupId>
                <artifactId>converter-gson</artifactId>
                <version>2.6.1</version>
            </dependency> 


        Notas:
            "A aplicação pretendida precisa de abrir uma ligação HTTP, criar um pedido GET, obter o JSON com a resposta, processar o conteúdo da resposta para usar o resultado. Há vários passos envolvidos, que podem ser grandemente simplificados recorrendo a bibliotecas externas. O uso dessas bibliotecas (ou artifacts) dá origem a dependências e o maven facilita a sua gestão."
    
    4. Criar class Main (Diretorio: src>main>java>com.weatherradar>Main)

    5. Copiar static void main() (Fornecida no guião)

    6.Copiar classes fornecidas (no elearning) para o com.WeatherRadar

    7. Correr:
        1. $mvn clean package 
        2. $mvn exec:java -Dexec.mainClass="com.weatherradar.Main"


FINAL:

"No ficheiro “readme” da aula, responder às questões: o que é um “maven goal”? quais os principais “maven goals” e a respetiva sequência de invocação? "

O que é um Maven Goal
    R: Num projeto Maven temos várias "Build Phases" (Validate, Compile, Test-Compile, ... [Outras fases apontadas numa nota em cima]). Cada uma destas fases subdivide-se em vários objetivos/tarefas a cumprir. A estes objetivos (que em cada fase sao executdos ordenadamente) chamamos GOALS.
    Por outro lado, os Maven Plugins são tambem um grupo de GOALS. A diferença destes, porém, é que estes não pertencem à mesma Phase

Qual a sequencia de invocação de um Maven Goal
    R: A sequencia de invocação é fixa e predeterminada para cada fase. Usando o comando $mvn help:describe -Dcmd=PHASENAME podemos listar todos os goals bound à fase especificada por PHASENAME