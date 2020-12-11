// Pass the -scripting flag to Nashorn to execute
// the command in the back ticks
// Executing this script from Java, use a property to pass the flag:
// -Dnashorn.args=-scripting
var files = `ls`.trimRight().split("\n");

for each (var filename in filenames) {
    for each (var file in files) {
        if (filename == file) {
            print ("Found " + filename + " in the local directory") 
        }
    }
};