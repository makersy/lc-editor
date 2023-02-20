echo '-------- start push --------'

git add .

msg='day: '$(date +%y/%m/%d)

git commit -m "$msg"

echo '------- push success -------'