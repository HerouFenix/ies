https://github.com/HerouFenix/IES
Nota: Este repo sera usado, tanto para este exercicio, como para todos os outros exercicios realizados nesta cadeira, para que possam estar organizados, documentados e partilhados com quem precisar.

Nota: Este exercicio baseava-se na criação de novas features ao exercicio do WeatherRadar (Que se encontra no diretorio 1.1), pelo que os unicos conteudos nesta pasta serão apontamentos da resolução


Criação de um Remote
    1. Criar Repo (p.ex no github)

    Alt 1.
    2. $ cd project_folder 
    3. $ git init  # initialize a local git repo in this folder 
    4. $ git remote add origin https://github.com/HerouFenix/PraticasIES.git #adapt the url 
        (Se necessario:)
        $git checkout master
        $git pull
    5. $ git add .    # mark all existing changes in this root to be commited 
    6. $ git commit -m "Initial commit"  #create the commit snapshot locally 
    7. $ git push -u origin master  #uploads the local commit to the shared repo

    Alt 2.
    2. $git clone https://github.com/HerouFenix/PraticasIES.git
    3. Copiar ficheiros para dentro da nova pasta criada pelo clone
    4. $git add .
    5. $git commit -m "Mensagem"
    6. $git push



Comandos relacionados com Branches:
    Criação de Branches (cria branch local):
        $git checkout -b branch_nome

    Emporrar mudanças para remote (só necessario na primeira vez, depois é so git push)
        $git push -u origin branch_name

    Apagar branch local:
        $git remove -D branch_name (temos q tar checked out noutro branch)

    Verificar apenas branches remotos:
        $git branch -r

    Verificar apenas branches locais
        $git branch


    Mais info:
    https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow




Nota: Eu fiz a tarefa 1 enquanto que o Vasco a 2

Logger:
    1. No pom.xml importar as dependencias:
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.12.1</version>
        </dependency>
    2. Criar ficheiro log4j2.xml no src/main/resources
    3. Copiar (Ex. de configuraçao que escreve para a Consola e para um ficheiro chamado logger.log):
        <Configuration status="info">
            <Appenders>
                <Console name="Console" target="SYSTEM_OUT">
                    <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %p %m%n"/>
                </Console>
                <File name="File" fileName="logger.log" append="true">
                    <PatternLayout>
                        <Pattern>%d{yyyy-MM-dd HH:mm:ss} %-5p %m%n</Pattern>
                    </PatternLayout>
                </File>
            </Appenders>
            <Loggers>
                <Root level="info">
                    <AppenderRef ref="Console"/>
                    <AppenderRef ref="File"/>
                </Root>
            </Loggers>
        </Configuration>
    4. Na Main.java colocar:
        protected static final Logger logger = LogManager.getLogger();
    5. Na Main.java importar:
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger; 
    
