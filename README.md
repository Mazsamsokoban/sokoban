# Killer Sokoban
Maazsam csapat:
* Zsófi
* Ákos
* Ádám
* Sajt
* Marci

# Git
## Telepítés
https://git-scm.com/download/win
FONTOS!!! 
Run Git and included Unix tools from the Windows Command Prompt opciót válasszátok

## Git Bash segítség:
* git init <directory> - létrehoz egy mappát, ahol dolgozhattok
* cd <directory> - átválthatsz erre a mappára
* git clone <url> - a projekt leklónozása saját magatoknak, ezt kezditek el módosítani, és majd toljátok fel a módosításokat
* ls -l - kilitsázza a mappa tartalmát, amiben vagy
* git config --global user.name "Gipsz Jakab" - username beállítása
* git add <filenév> - új fájlt ad hozzá a commitolandó fájlok közé (homokozó a neve, angolul index)
* git status - meg tudod nézni a hozzáadott fájlokat
* git commit -a - szövegfájlban megmutatja a commitolandó fájlokat
* git commit -m "üzenet" - valamilyen üzenettel commitolja (betölti) az index tartalmát a lokális repositoryba
* git log --oneline --graph --decorate - szépen gráfosan kirajzolja a commitokat

## Az online repository beállítása:
* git clone <url> - EZZEL ÉRDEMES KEZDENI
* git remote add origin <url, ami a projekt url-je, ahova pull requestet szeretnél> 
* git remote -v - a remoteok státusza

## Feltöltés az online repositoryba:
* git pull origin master - a mások által végrehajtott változtatások letöltése
* git push origin master - a mi változtatásaink életbe léptetésének kérelme

2018.03.07 GitHub demo
