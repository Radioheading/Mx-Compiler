import os
import sys

command = "java -jar ../MxCompiler.jar < {input_file} > {output_file}"

judge_list = open("../testcases/sema/judgelist.txt").readlines()

win = 0
lose = 0
sum = 0
cnt = 0

for judge in judge_list:
    cnt += 1
    input_file = judge.replace("\n", "").replace("./", "../testcases/sema/")
    output_file = "result/" + str(cnt) + ".txt"

    fp = open(input_file)
    lines = fp.readlines()
    std = ""
    cmt = ""
    isSuccess = False
    for line in lines:
        if line.find("Verdict") != -1:
            std = line.replace("\n", "")
            if "Success" in std:
                isSuccess = True
        if line.find("Comment") != -1:
            cmt = line.replace("\n", "")

    print("[std]", std, cmt)
    sum = sum + 1
    res = os.system(command.format(input_file = input_file, output_file = output_file))
    if res != 0 and isSuccess == False or res == 0 and isSuccess == True:
        print("\033[32m[Success] [test]:, point " + str(cnt))
        win = win + 1
    else:
        print("\033[31m[Failed] [test]:, point " + str(cnt))
        lose = lose + 1
    print("testing case:", cnt, input_file, "\n")
print("all: ", sum, "\n")
print("success: ", win, "\n")