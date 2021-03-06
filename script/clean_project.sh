#!/bin/bash

PRO=`cd \` dirname $0 \` cd .. ; cd ..;  pwd `
# 输出当前文件目录
echo "current project path is  ->  $PRO"

cd ..

rm -rf $PRO/logs
rm -rf $PRO/.idea
# 删除 .iml 文件 和 target 文件夹
find $PRO -name "*.iml"  | xargs rm -rf
find $PRO -name "target"  | xargs rm -rf
