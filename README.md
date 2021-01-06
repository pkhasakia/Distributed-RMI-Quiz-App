# RMI Quiz Application

# The Application
For this application, I have used two interface files which include remote methods, as well as an implementation file that includes
the method code and their functionalities. I used a client java file that uses a file interface object to call methods from the server and allow the functionalities
and novel features to operate. The server uses rmi registry to to bind remote objects to names. Clients on local and remote hosts can look up remote objects and make
remote method invocations. 

# Instructions
After you have downloaded the code on to your machine:
1. Open two CMD terminals.
2. In one terminal, navigate to the directory that has the server files. Likewise, the other terminal for the client files.
3. On the server terminal, start by compiling all java files.
4. Now run command **rmic FileImpl**. This will produce a stub class file. Copy and paste the stub file into the client folder.
5. Now run **start rmiregistry**. This will open a seperate window that can be minimized.
6. Now run **java -Djava.security.policy=policy.txt FileServer**. The server should display that it has started.
7. On the client terminal, compile all java files.
8. Run **java FileClient nameofyourpc or localhost**. The quiz application will start.
