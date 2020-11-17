cd %1
 
for /R %1 %%F IN (*.tgz) DO (
7z x "%%F"
)
for /R %1 %%F IN (*.tar) DO (
7z e "%%F" -o%2 *.eml -r
)
