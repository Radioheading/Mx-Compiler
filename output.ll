; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@str.0 = private unnamed_addr constant [4 x i8] c"<< \00"
@str.3 = private unnamed_addr constant [2 x i8] c" \00"
@str.4 = private unnamed_addr constant [4 x i8] c">> \00"
@str.2 = private unnamed_addr constant [3 x i8] c") \00"
@str.1 = private unnamed_addr constant [2 x i8] c"(\00"
declare void @print(ptr)
declare void @println(ptr)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare ptr @getString()
declare i32 @getInt()
declare ptr @toString(i32)
declare ptr @__malloc(i32)
declare i32 @__array_size(ptr)
declare ptr @__str_add(ptr, ptr)
declare i8 @__str_eq(ptr, ptr)
declare i8 @__str_ne(ptr, ptr)
declare i8 @__str_lt(ptr, ptr)
declare i8 @__str_le(ptr, ptr)
declare i8 @__str_gt(ptr, ptr)
declare i8 @__str_ge(ptr, ptr)
declare i32 @__str_length(ptr)
declare ptr @__str_substring(ptr, i32, i32)
declare i32 @__str_parseInt(ptr)
declare i32 @__str_ord(ptr, i32)
@n = dso_local global i32 0
@p = dso_local global i32 0
@k = dso_local global i32 0
@i = dso_local global i32 0
define dso_local i32 @main() {

enter_main_0:
store i32 0, ptr %ret_main_0
call void @__mx_global_var_init()
%short_cond_0 = alloca i8
%ret_main_0 = alloca i32
%_1 = call i32 @getInt()
store i32 %_1, ptr @n
%_3 = call i32 @getInt()
store i32 %_3, ptr @p
%_5 = call i32 @getInt()
store i32 %_5, ptr @k
%_8 = load i32, ptr @p
%_10 = load i32, ptr @k
%sub_0 = sub i32 %_8, %_10
%sgt_0 = icmp sgt i32 %sub_0, 1
br i1 %sgt_0, label %if.then_0, label %if.end_0

if.then_0:
call void @print(ptr @str.0)
br label %if.end_0

if.end_0:
%_17 = load i32, ptr @p
%_19 = load i32, ptr @k
%sub_1 = sub i32 %_17, %_19
store i32 %sub_1, ptr @i
br label %for.cond_0

for.cond_0:
%_22 = load i32, ptr @p
%_24 = load i32, ptr @k
%add_0 = add i32 %_22, %_24
%_26 = load i32, ptr @i
%sle_0 = icmp sle i32 %_26, %add_0
br i1 %sle_0, label %for.body_0, label %for.end_0

for.inc_0:
%_30 = load i32, ptr @i
%inc_0 = add i32 %_30, 1
store i32 %inc_0, ptr @i
br label %for.cond_0

for.body_0:
%_34 = load i32, ptr @i
%sle_1 = icmp sle i32 1, %_34
br i1 %sle_1, label %short.rhs_0, label %short.quick_0

short.rhs_0:
%_37 = load i32, ptr @i
%_39 = load i32, ptr @n
%sle_2 = icmp sle i32 %_37, %_39
%frombool_0 = zext i1 %sle_2 to i8
store i8 %frombool_0, ptr %short_cond_0
br label %short.end_0

short.quick_0:
store i8 0, ptr %short_cond_0
br label %short.end_0

short.end_0:
%_43 = load i8, ptr %short_cond_0
%_65 = trunc i8 %_43 to i1
br i1 %_65, label %if.then_1, label %if.end_1

if.then_1:
%_46 = load i32, ptr @i
%_48 = load i32, ptr @p
%_49 = icmp eq i32 %_46, %_48
br i1 %_49, label %if.then_2, label %if.else_2

if.then_2:
call void @print(ptr @str.1)
%_55 = load i32, ptr @i
%_53 = call ptr @toString(i32 %_55)
call void @print(ptr %_53)
call void @print(ptr @str.2)
br label %if.end_2

if.else_2:
%_61 = load i32, ptr @i
call void @printInt(i32 %_61)
call void @print(ptr @str.3)
br label %if.end_2

if.end_2:
br label %if.end_1

if.end_1:
br label %for.inc_0

for.end_0:
%_67 = load i32, ptr @p
%_69 = load i32, ptr @k
%add_1 = add i32 %_67, %_69
%_72 = load i32, ptr @n
%slt_0 = icmp slt i32 %add_1, %_72
br i1 %slt_0, label %if.then_3, label %if.end_3

if.then_3:
call void @print(ptr @str.4)
br label %if.end_3

if.end_3:
store i32 0, ptr %ret_main_0
br label %exit_main_0

exit_main_0:
%_0 = load i32, ptr %ret_main_0
ret i32 %_0

}
define dso_local void @__mx_global_var_init() {

enter___mx_global_var_init_0:
br label %exit___mx_global_var_init_0

exit___mx_global_var_init_0:
ret void

}

