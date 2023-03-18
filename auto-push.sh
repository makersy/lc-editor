#!/bin/bash -e

echo '-------- Start push --------'

git add .

msg='day: '$(date +%y/%m/%d)

if ! git commit -m "$msg"; then
    echo "Commit failed"
fi

if ! git push; then
    echo "Push failed"
    exit 1
fi

echo "------- Push success -------"
exit 0