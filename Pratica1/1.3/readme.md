1. Tutorials and getting started
    https://docs.docker.com/get-started/

    Nota: Para instalar o Docker no windows teria que ter a versão Windows10 Pro (pq a Home não suporta HyperV). Alternativamente, use a Virtual Box dummy

    Some Commands:
        ## List Docker CLI commands
        docker
        docker container --help

        ## Display Docker version and info
        docker --version
        docker version
        docker info

        ## Execute Docker image
        docker run hello-world

        ## List Docker images
        docker image ls

        ## List Docker containers (running, all, all in quiet mode)
        docker container ls
        docker container ls --all
        docker container ls -aq

    
2. Setting up Containers
    https://docs.docker.com/get-started/part2/

    1. Create Dockerfile ("Dockerfile defines what goes on in the environment inside your container." - Basicamente as dependencias da app)

    2. Criar a app (no caso deste tutorial, criamos um requirements.txt e um app.py) ["When the above Dockerfile is built into an image,app.py and requirements.txt is present because of that Dockerfile’s COPY command, and the output from app.py is accessible over HTTP thanks to the EXPOSE command."] ["That’s it! You don’t need Python or anything in requirements.txt on your system, nor does building or running this image install them on your system. It doesn’t seem like you’ve really set up an environment with Python and Flask, but you have."] -> This is actually pretty dope :o

    3. Build a app:
        $ docker build --tag=friendlyhello . 
        (ou --tag=friendlyhello:v0.0.1 . se quisere especificar a versão da imagem)
            ->"This creates a Docker image, which we’re going to name using the --tag option. Use -t if you want to use the shorter option."

        Verificar se foi criada: docker ls image

    4. Correr a app:
        $ docker run -p 4000:80 friendlyhello

        $ docker run -d -p 4000:80 friendlyhello 
            ->"Now let’s run the app in the background, in detached mode (...) You get the long container ID for your app and then are kicked back to your terminal. Your container is running in the background. You can also see the abbreviated container ID with docker container ls (and both work interchangeably when running commands)"

            $ docker container ls
            CONTAINER ID        IMAGE               COMMAND             CREATED
            1fa4ab2cf395        friendlyhello       "python app.py"     28 seconds ago

            Parar app a correr em Background:    
                $ docker container stop 1fa4ab2cf395 (onde este numero é o Container ID)

    5. Partilhar imagem

        1. $ docker login (Login)
        2. $ docker tag friendlyhello fenixds/get-started:part2 (Tag Image)
        3. $ docker push fenixds/get-started:part2

        Nota: Quando estava a fazer o guião não estava a conseguir fazer login pelo terminal somewhy :( 

            
        
3. Portainer
    Instalar Portainer: 
        1. https://www.portainer.io/installation/
        2. Depois aceder a localhost:9000 (se seguir os comandos na pagina de instalação, else, whatever port u defined)


    Postgres:
        1. Criar um container novo Postgres
        2. Aceder à Consola no Container (atraves do UI)

        3. $ su - postgres                 

        4. Seguir https://www.a2hosting.com/kb/developer-corner/postgresql/managing-postgresql-databases-and-users-from-the-command-line (para criar um user and some stuff)

        5. $ psql

        6. \l (listar bases de dados para verificar q foi criada)


    Nota: Para manter persistencia de dados (mesmo quando se apaga o Container) seria necessario criar um Volume e associa lo ao container. Porem isto e feito automaticamente quando criamos o container no Portainer. Quando tentamos remover o Container o portainer depois pergunta se queremos tambem remover o Volume ou mante-lo.. Nice
