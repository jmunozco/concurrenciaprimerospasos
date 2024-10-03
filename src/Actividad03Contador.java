

class DownloadThread extends Thread {
    long timeStartMillis = 0;
    long timeEndMillis = 0;
    String fileName;
    static long timeMs = 0;

    public DownloadThread (String fileName, long timeMs) {
        this.fileName = fileName;
        this.timeMs = timeMs;
    }

    public void run () {
        try {
            timeStartMillis = System.currentTimeMillis();
            System.out.println("Tiempo inicial "+this.timeStartMillis + " para "+this.fileName);
            System.out.println("Iniciando descarga "+this.fileName);
            Thread.sleep(this.timeMs); //throws IllegalArgumentException, InterruptedException
            System.out.println("Terminada descarga "+this.fileName);
            timeEndMillis = System.currentTimeMillis();

            synchronized (DownloadThread.class) {
                timeMs += timeEndMillis - timeStartMillis;
            }

            System.out.println("Tiempo final "+this.timeEndMillis + " para "+this.fileName);
            System.out.println("Tiempo total del fichero "+this.fileName+ " es " + (timeEndMillis-timeStartMillis));


        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    public static long getTimeMs () {
        return timeMs;
    }
}


public class Actividad03Contador {
    public static void main (String []args)  {
        DownloadThread[] downloadThreads = new DownloadThread[6];
        downloadThreads[0] = new DownloadThread("File1",16000);
        downloadThreads[1] = new DownloadThread("File2",500);
        downloadThreads[2] = new DownloadThread("File3",250);
        downloadThreads[3] = new DownloadThread("File4",6000);
        downloadThreads[4] = new DownloadThread("File5",7500);
        downloadThreads[5] = new DownloadThread("File6",3000);

        try {
            for (DownloadThread downloadThread : downloadThreads) {
                downloadThread.start();
            }

            for (DownloadThread downloadThread : downloadThreads) {
                downloadThread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("TIEMPO TOTAL: "+DownloadThread.getTimeMs());
    }
}
