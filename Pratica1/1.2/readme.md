https://github.com/HerouFenix/PraticasIES
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

