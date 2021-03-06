package org.tizen.gradle
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.InvalidUserDataException
import org.gradle.StartParameter
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.JavaExec
import java.nio.file.Files
import java.nio.file.Paths
import static groovy.io.FileType.FILES
import org.apache.tools.ant.taskdefs.condition.Os

class TizenTask extends DefaultTask{

    public void exec(String args) {
        Tizen tizen = project.tizen;
        def proc = null;
        int exit;
        String command = project.ext.get('sdk.dir');

        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            command += "/tools/ide/bin/tizen.bat ";
        } else if (Os.isFamily(Os.FAMILY_MAC)) {
            command += "/tools/ide/bin/tizen ";
        } else if (Os.isFamily(Os.FAMILY_UNIX)) {
            command += "/tools/ide/bin/tizen ";
        }

        command += args;

        logger.info("command: " + command);

        if(command){
            proc = command.split().toList().execute();
            proc.consumeProcessOutput(sout, serr);
            proc.waitFor();

            exit = proc.exitValue();

            println("stdandard output of tizen command: \n$sout");
            println("stdandard error of tizen command: \n$serr");
        }
    }
}

