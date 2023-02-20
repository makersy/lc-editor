echo '-------- start push --------'

git add .

msg='day: '$(date +%y/%m/%d)

git commit -m "$msg"

git push -u origin master

echo '------- push success -------'