# pro-3bi-anj2
# piskorky - spuštění serveru v Ubuntu
```
wget https://github.com/SPSMB/pro-3bi-anj2/raw/main/src/cz/spsmb/b3i/w24/piskorky/PiskorkyServer.java
wget https://github.com/SPSMB/pro-3bi-anj2/raw/main/src/cz/spsmb/b3i/w24/piskorky/PiskorkyStatus.java
echo "Main-Class: PiskorkyServer.class" > MANIFEST.MF
mkdir -p cz/spsmb/b3i/w24/piskorky
javac PiskorkyStatus.java PiskorkyServer.java
mv *.class cz/spsmb/b3i/w24/piskorky/
java cz.spsmb.b3i.w24.piskorky.PiskorkyServer
```
