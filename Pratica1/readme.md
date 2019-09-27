Autor: Diogo Gonçalves Silva
nMec: 89348
Curso: LEI

Nota: Todos os apontamentos foram registados em readme.md's separados, de forma a garantir uma melhor e mais bem estruturada organização destes. Cada um destes ficheiros encontra-se no direitorio relativo ao exercício que acompanham (i.e apontamentos sobre os exercicios 1.1 encontram-se no diretorio 1.1)

Nota: Os exercícios de cada questão encontram-se dentro do respetivo diretorio (p.ex o "lab1_3-2.log" encontrase no diretorio 1.2)

Exercícios:
1.1
    O que é um Maven Goal?
        R: Num projeto Maven temos várias "Build Phases" (Validate, Compile, Test-Compile, ... [Outras fases apontadas numa nota em cima]). Cada uma destas fases subdivide-se em vários objetivos/tarefas a cumprir. A estes objetivos (que em cada fase sao executdos ordenadamente) chamamos GOALS.
    Por outro lado, os Maven Plugins são tambem um grupo de GOALS. A diferença destes, porém, é que estes não pertencem à mesma Phase

    Qual a sequencia de invocação de um Maven Goal?
        R: A sequencia de invocação é fixa e predeterminada para cada fase. Usando o comando $mvn help:describe -Dcmd=PHASENAME podemos listar todos os goals bound à fase especificada por PHASENAME


1.2 (github: https://github.com/HerouFenix/PraticasIES)
    * 46d4c32 (HEAD -> master, origin/master) Dockerfiles added
    * ed5b58d Pratica 1.3 readme
    * 29d5af8 Started Docker 1.3
    *   773eae7 merge conflicts
    |\  
    | *   9499c39 Merge pull request #2 from HerouFenix/feature/city_name_as_argument
    | |\  
    | | * bdcba35 (origin/feature/city_name_as_argument) Minor update to xml
    | | * ff18d24 Now we pass the city's name and the code find the respetive city code and displays the temperature of that city
    | |/  
    * | 3e4c2dc Created 1.3 folder
    |/  
    *   a4e01ca Merge pull request #1 from HerouFenix/pratica1/ex2/logging_support
    |\  
    | * 07b8664 Created a logger ; added dependencies ; all that jazz
    |/  
    * 120174b Small fixes and auto exit
    * 8195895 Aula Pratica 1 - Initial Commit
    * 800ba9f Initial commit



1.3
    Resultado do comando: $ docker container ls --all 
        R:
            CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
            f7f821b6b685        postgres:latest     "docker-entrypoint.s…"   30 minutes ago      Up 8 minutes        5432/tcp            PostGresPratica1.3

    Conteúdo dos Dockerfile criados. 
        R:
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