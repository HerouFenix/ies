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



Perguntas Finais:
    $docker container ls --all
        CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
        f7f821b6b685        postgres:latest     "docker-entrypoint.s…"   30 minutes ago      Up 8 minutes        5432/tcp            PostGresPratica1.3

    Dockerfiles:
        1. 
            # Use an official Python runtime as a parent image
            FROM python:2.7-slim

            # Set the working directory to /app
            WORKDIR /app

            # Copy the current directory contents into the container at /app
            COPY . /app

            # Install any needed packages specified in requirements.txt
            RUN pip install --trusted-host pypi.python.org -r requirements.txt

            # Make port 80 available to the world outside this container
            EXPOSE 80

            # Define environment variable
            ENV NAME World

            # Run app.py when the container launches
            CMD ["python", "app.py"]

        2.
            1 	55.3 MB 	
            ADD file:e82c447c3eae5d1d0282d8557b0c271b29d1be0d0f23204a09ad468be7a80d8c in /
            2 	0 B 	
            CMD ["bash"]
            3 	10.2 MB 	
            RUN set -ex; if ! command -v gpg > /dev/null; then apt-get update; apt-get install -y --no-install-recommends gnupg ...
            4 	328.6 kB 	
            RUN set -eux; groupadd -r postgres --gid=999; useradd -r -g postgres --uid=999 --home-dir=/var/lib/postgresql --shell=/bin/ba...
            5 	0 B 	
            ENV GOSU_VERSION=1.11
            6 	4 MB 	
            RUN set -x && apt-get update && apt-get install -y --no-install-recommends ca-certificates wget && rm -rf /var/lib/apt/lists/*...
            7 	16.5 MB 	
            RUN set -eux; if [ -f /etc/dpkg/dpkg.cfg.d/docker ]; then grep -q '/usr/share/locale' /etc/dpkg/dpkg.cfg.d/docker; sed -ri...
            8 	0 B 	
            ENV LANG=en_US.utf8
            9 	1.1 MB 	
            RUN set -eux; apt-get update; apt-get install -y --no-install-recommends libnss-wrapper; rm -rf /var/lib/apt/lists/*
            10 	0 B 	
            RUN mkdir /docker-entrypoint-initdb.d
            11 	4.6 kB 	
            RUN set -ex; key='B97B0AFCAA1A47F044F244A07FCC7D46ACCC4CF8'; export GNUPGHOME="$(mktemp -d)"; gpg --batch --keyserver ha.poo...
            12 	0 B 	
            ENV PG_MAJOR=11
            13 	0 B 	
            ENV PG_VERSION=11.5-1.pgdg90+1
            14 	224.9 MB 	
            RUN set -ex; export PYTHONDONTWRITEBYTECODE=1; dpkgArch="$(dpkg --print-architecture)"; case "$dpkgArch" in amd64|i386|p...
            15 	48.1 kB 	
            RUN set -eux; dpkg-divert --add --rename --divert "/usr/share/postgresql/postgresql.conf.sample.dpkg" "/usr/share/postgresql/$...
            16 	0 B 	
            RUN mkdir -p /var/run/postgresql && chown -R postgres:postgres /var/run/postgresql && chmod 2777 /var/run/postgresql
            17 	0 B 	
            ENV PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/postgresql/11/bin
            18 	0 B 	
            ENV PGDATA=/var/lib/postgresql/data
            19 	0 B 	
            RUN mkdir -p "$PGDATA" && chown -R postgres:postgres "$PGDATA" && chmod 777 "$PGDATA"
            20 	0 B 	
            VOLUME [/var/lib/postgresql/data]
            21 	5.5 kB 	
            COPY file:821a5675752f9e8c7b4118e7184c6f65d810150cd254bac8cfda104cdb7f0298 in /usr/local/bin/
            22 	34 B 	
            RUN ln -s usr/local/bin/docker-entrypoint.sh / # backwards compat
            23 	0 B 	
            ENTRYPOINT ["docker-entrypoint.sh"]
            24 	0 B 	
            EXPOSE 5432
            25 	0 B 	
            CMD ["postgres"] 