package org.tizen.gradle

import org.gradle.api.InvalidUserDataException

class TizenBuild extends TizenTask {

    @Override
        def configure(Tizen tizen) {
            println("TizenBuild: configure " + "start");

            super.configure(tizen);

            tizen.sdk.args = "build-native";

            if(tizen.build_native.arch){
                tizen.sdk.args += " --arch " + tizen.build_native.arch;
            }
            if(tizen.build_native.compiler){
                tizen.sdk.args += " --compiler " + tizen.build_native.compiler;
            }
            if(tizen.build_native.configuration){
                tizen.sdk.args += " --configuration " + tizen.build_native.configuration;
            }
            if(tizen.build_native.jobs){
                tizen.sdk.args += " --jobs " + tizen.build_native.jobs;
            }

            tizen.sdk.args += " -- ./";

            println("TizenTask: args " + tizen.sdk.args);

            println("TizenBuild: configure " + "end");
        }

}