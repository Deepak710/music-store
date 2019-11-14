# music-store

## Online Website built using Maven, implementing Spring and Hibernate

### To Run this file,
1. Download [Eclipse](http://www.eclipse.org/downloads/ "Eclipse Java IDE"), [Apache Tomcat](https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.10/bin/ "Apache Tomcat Server") and [H2](http://www.h2database.com/h2-setup-2017-06-10.exe "H2 Database")
1. Make sure [Java](https://java.com/en/download/ "Java Runtime Environment") and [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html "Java Development Kit Standard Edition") is installed
1. Import Project Directly to Eclipse by:
    * 'Help > Install New Software > All Avaliable Sites > Web, XML, JavaEE > Install' then Restart
    * Make git repository view visible in Eclipse from the menu 'Window > Show views > Other > Git > Git Repositories'
    * Click on 'Clone a Git repository'
    * Give Source as https://github.com/Deepak710/music-store.git
    * Give the directory where the project is to be cloned. **Make sure to check the box 'Import all existing Eclipse project after clone finishes'**
    * 'Properties > Java Build Path > Libraries > JRE System Libraries > Edit > Alternate JRE' and give the path to Java JDK instead of JRE **important**
1. Run Queries.sql on H2 in a database called musicstore
   * Run H2 Console
   * Change saved settings to 'Generic H2 Server'
   * Change JDBC URL to 'jdbc:h2:tcp://localhost/~/musicstore'
   * If database name [or] username/password needs to be changed, make sure to reflect the changes in 'MusicBack > src > main > java > DMB > PRJ > MusicBack > config > HibernateConfig.java'
1. Run the project on Tomcat Server in Eclipse
   * 'Windows > Preferences > Server > Runtime Environments > Add... > Apache Tomcat v9.0'
   * Browse for the install directory of Tomcat

### Features:
* Get the Project report [here](https://drive.google.com/open?id=1k9a3gJPrgn0iOOU6jF0xB1z--LzylWpf "Project Report.pdf")

Contact Me: [Telegram](https://t.me/AzorAhoy)
