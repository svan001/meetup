# Meetup !

## Tuto/proc d'install

### Reload spring boot / IntelliJ

* Devtools
* Soit "Make" à la main, soit forcer la compilation auto (explication ici : https://patrickgrimard.io/2016/01/18/spring-boot-devtools-first-look/)
 
## Base de donées

### Install mongo

* Install : `sudo apt-get install mongodb`
* **/!\ Limiter la taille du journal : **
    * Editer `/etc/mongodb.conf` pour ajouter `smallfiles=true`
    * Via CL : `echo smallfiles=true >> /etc/mongodb.conf`
* Démmarrage : ``

### Créer la base 
