# pro-3bi-anj2
# piskorky - spuštění serveru v Ubuntu
```
wget https://github.com/SPSMB/pro-3bi-anj2/raw/main/src/cz/spsmb/b3i/w24/piskorky/PiskorkyServer.java
wget https://github.com/SPSMB/pro-3bi-anj2/raw/main/src/cz/spsmb/b3i/w24/piskorky/PiskorkyStatus.java
wget https://github.com/SPSMB/pro-3bi-anj2/raw/main/src/cz/spsmb/b3i/w24/piskorky/ServerThread.java
#echo "Main-Class: cz/spsmb/b3i/w24/piskorky/PiskorkyServer.class" > MANIFEST.MF
mkdir -p cz/spsmb/b3i/w24/piskorky
javac PiskorkyStatus.java PiskorkyServer.java ServerThread.java
rm  *.java
mv *.class cz/spsmb/b3i/w24/piskorky/
jar -c -e cz.spsmb.b3i.w24.piskorky.PiskorkyServer -f PiskorkyServer.jar cz
#java cz.spsmb.b3i.w24.piskorky.PiskorkyServer
java -jar PiskorkyServer.jar

```
