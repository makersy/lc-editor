#!/bin/bash -e

echo '-------- start push --------'

git add .

msg='day: '$(date +%y/%m/%d)

git commit -m "$msg"

git push

echo '------- push success -------'