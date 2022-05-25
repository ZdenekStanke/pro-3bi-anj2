package cz.spsmb.b3i.w35.maven;
// Apache Maven - nástroj pro správu projektu, nástupce Apache Ant.
// Nutno zmínit, že jeden z nejstarších a dochovalých nástrojů
// pro správu projektu je GNU Make.

// Nový projekt -> Maven
// Přidání závislostí:
// Otevřít pom.xml, alt+insert -> přidat Dependency

// Možnost vygenerování jar souboru pomocí mvn install:
// Otevřít pom.xml, alt+insert -> přidat plugin a nakonfigurovat:

//<build>
//  <plugins>
//    <plugin>
//      <groupId>org.apache.maven.plugins</groupId>
//      <artifactId>maven-jar-plugin</artifactId>
//      <version>2.4</version>
//      <configuration>
//        <archive>
//          <manifest>
//            <addClasspath>true</addClasspath>
//            <mainClass>dbTest.AutoimkrementId</mainClass>
//          </manifest>
//        </archive>
//      </configuration>
//    </plugin>
//  </plugins>
//</build>

// Ještě lépe pro JavaFX:
/*
<plugin>
  <artifactId>maven-shade-plugin</artifactId>
  <version>3.3.0</version>
  <executions>
    <execution>
      <phase>package</phase>
      <goals><goal>shade</goal></goals>
      <configuration>
        <transformers>
          <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
          <mainClass>SuperMain</mainClass>
          </transformer>
        </transformers>
      </configuration>
    </execution>
  </executions>
</plugin>
*/
// pak použít mvn package

// Pro import JavaFX použijte následující návod:
//https://openjfx.io/openjfx-docs/#maven
public class Uvod {
}
