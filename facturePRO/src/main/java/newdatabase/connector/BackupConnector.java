package newdatabase.connector;

import newdatabase.HibernateUtil;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;


public class BackupConnector {

    public static void main(String[] args) {


        try {
            makeBackup();
            loadBackup();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void makeBackup() throws URISyntaxException, IOException, InterruptedException {
        CodeSource codeSource = BackupConnector.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();


        Configuration conf = HibernateUtil.getConfiguration();
        String dbName = "ivodb";
        String dbUser = conf.getProperty("hibernate.connection.username");
        String dbPass = conf.getProperty("hibernate.connection.password");

        /*NOTE: Creating Path Constraints for folder saving*/
        /*NOTE: Here the backup folder is created for saving inside it*/
        String folderPath = jarDir + "\\backup";
        /*NOTE: Creating Folder if it does not exist*/
        File f1 = new File(folderPath);
        f1.mkdir();

        /*NOTE: Creating Path Constraints for backup saving*/
        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
        String savePath = "\"" + jarDir + "/" + "backup.sql\"";

        /*NOTE: Used to create a cmd command*/
        String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " " + dbName + " -r " + savePath;
        String[] cmdarr = {"/bin/sh", "-c", executeCmd};
        System.out.println(executeCmd);
        Process runtimeProcess = Runtime.getRuntime().exec(cmdarr);
        int processComplete = runtimeProcess.waitFor();

        if (processComplete == 0) {
            JOptionPane.showMessageDialog(null, "Successfully backuped to SQL : " + "backup.sql");
        } else {
            JOptionPane.showMessageDialog(null, "Backup Failure");


        }
    }

    public static void loadBackup() throws URISyntaxException, IOException, InterruptedException {

        CodeSource codeSource = BackupConnector.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();


        Configuration conf = HibernateUtil.getConfiguration();
        String dbName = "ivodb";
        String dbUser = conf.getProperty("hibernate.connection.username");
        String dbPass = conf.getProperty("hibernate.connection.password");


        String restorePath = "\"" + jarDir + "/" + "backup.sql\"";

        String executeCmd = "mysql " + " -u" + dbUser + " -p" + dbPass + " " + dbName + " < " + restorePath;
        String[] cmdarr = {"/bin/sh", "-c", executeCmd};
        System.out.println(executeCmd);


        Process runtimeProcess = Runtime.getRuntime().exec(cmdarr);
        int processComplete = runtimeProcess.waitFor();


        if (processComplete == 0) {
            JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " + "backup.sql");
        } else {
            JOptionPane.showMessageDialog(null, "Error at restoring");
        }
    }
}
