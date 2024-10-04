/*
Crea una clase llamada DownloadThread que extienda la clase Thread. Esta clase simulará la descarga de un archivo.
La clase DownloadThread debe tener:
- Un constructor que reciba el nombre del archivo y el tiempo que tardará en descargarse (en milisegundos).
- Un método run() que simule la descarga del archivo, mostrando un mensaje al inicio y otro al finalizar la descarga, junto con el nombre del archivo.
- Desde la clase principal del programa (MainClass), lanza al menos 5 descargas simultáneas, cada una con un nombre de archivo distinto y diferentes tiempos de descarga.
- Utiliza el método start() para iniciar los hilos y join() para asegurarte de que el programa espera a que todas las descargas terminen antes de mostrar el mensaje final: "Todas las descargas han finalizado".
- Opcionalmente, añade un contador que calcule el tiempo total de descarga desde que comienza la primera descarga hasta que finaliza la última.

- Añadiendo algo de informacion para probar git y los commits

 */
package dam.start;

class DownloadThread extends Thread {
    //int contador = 0;
    String fileName;
    long timeMs = 0;

    public DownloadThread (String fileName, long timeMs) {
        this.fileName = fileName;
        this.timeMs = timeMs;
    }

    public void run () {
        try {
            System.out.println("Iniciando descarga "+this.fileName);
            Thread.sleep(this.timeMs); //throws IllegalArgumentException, InterruptedException
            System.out.println("Terminada descarga "+this.fileName);

            //aquí me falta algo relativo al contador
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

public class Actividad03 {
    public static void main (String []args)  {
        long timeStartMillis = System.currentTimeMillis();

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

        long timeEndMillis = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (timeEndMillis - timeStartMillis));
    }
}
