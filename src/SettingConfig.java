/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author xsxiao
 */
public class SettingConfig {
<<<<<<< HEAD
//    private String dotPath = "/opt/local/bin/dot";
    private String dotPath = "/usr/local/bin/dot";
    private String browserPath = "open -a Google\\ Chrome";
    private String outputPath = "/Users/lingchen/PolicyGraphOutput";
=======
    private String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
    private String browserPath = "open -a Google\\ Chrome";
    private String outputPath = ".";
>>>>>>> 3e2a4d424aaa26f29254930c58a1ab8cba12922d

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getDotPath() {
        return dotPath;
    }

    public void setDotPath(String dotPath) {
        this.dotPath = dotPath;
    }

    public String getBrowserPath() {
        return browserPath;
    }

    public void setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
    }
    
}
