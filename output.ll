; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@str.0 = private unnamed_addr constant [4 x i8] c">> \00"
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
@k = dso_local global i32 0
define dso_local i32 @main() {

enter_main_0:
%i_0 = alloca i32
%p_0 = alloca i32
%ret_main_0 = alloca i32
store i32 0, ptr %ret_main_0
call void @__mx_global_var_init()
store i32 79, ptr @n
store i32 35, ptr %p_0
store i32 12, ptr @k
store i32 23, ptr %i_0
br label %for.cond_0

for.cond_0:
%_6 = load i32, ptr %p_0
%_8 = load i32, ptr @k
%add_0 = add i32 %_6, %_8
%_10 = load i32, ptr %i_0
%slt_0 = icmp slt i32 %_10, %add_0
br i1 %slt_0, label %for.body_0, label %for.end_0

for.inc_0:
%_14 = load i32, ptr %i_0
%inc_0 = add i32 %_14, 1
store i32 %inc_0, ptr %i_0
br label %for.cond_0

for.body_0:
br label %for.inc_0

for.end_0:
%_17 = load i32, ptr %p_0
%_19 = load i32, ptr @k
%add_1 = add i32 %_17, %_19
%_22 = load i32, ptr @n
%slt_1 = icmp slt i32 %add_1, %_22
br i1 %slt_1, label %if.then_0, label %if.end_0

if.then_0:
call void @print(ptr @str.0)
br label %if.end_0

if.end_0:
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

