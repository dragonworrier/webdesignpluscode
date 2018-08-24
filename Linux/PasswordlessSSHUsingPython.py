import subprocess

def connect_ssh():
    sshProcess = subprocess.Popen(['ssh', 
                   'admin@192.168.1.1'],
                   stdin=subprocess.PIPE, 
                   stdout = subprocess.PIPE,
                   universal_newlines=True,
                   bufsize=0)
    return sshProcess


sshProcess = connect_ssh()
sshProcess.stdin.write("your command here.")
sshProcess.stdin.close()
for line in sshProcess.stdout:
    print(line)
