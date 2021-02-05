package schedulertasks.scheduler.tasks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LocalLinuxShell {	

	    public void executeCommand(String command) throws IOException {

	        final ArrayList<String> commands = new ArrayList<String>();
	        commands.add("/bin/bash");
	        commands.add("-c");
	        commands.add(command);

	        BufferedReader br = null;

	        try {
	            final ProcessBuilder p = new ProcessBuilder(commands);
	            final Process process = p.start();
	            final InputStream is = process.getInputStream();
	            final InputStreamReader isr = new InputStreamReader(is);
	            br = new BufferedReader(isr);

	            String line;
	            while((line = br.readLine()) != null) {
	            	System.out.println("jShell => " + line);
	            }
	        } catch (IOException ioe) {
	            System.out.println("Erro ao executar comando shell" + ioe.getMessage());
	            throw ioe;
	        } finally {
	            secureClose(br);
	        }
	    }

	    private void secureClose(final Closeable resource) {
	        try {
	            if (resource != null) {
	                resource.close();
	            }
	        } catch (IOException ex) {
	        	System.out.println("Erro = " + ex.getMessage());
	        }
	    }
	    
	    @Scheduled(fixedRate=3000)
	    public static void printDate () throws IOException {
			LocalLinuxShell shell = new LocalLinuxShell();        
	        shell.executeCommand("date");
	    }	    

}
