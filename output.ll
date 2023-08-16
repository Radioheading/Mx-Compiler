; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@str.0 = private unnamed_addr constant [2 x i8] c" \00"
@str.1 = private unnamed_addr constant [8 x i8] c"Total: \00"
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
@N = dso_local global i32 15000
@b = dso_local global ptr null
@resultCount = dso_local global i32 0
define dso_local i32 @main() {

enter_main_0:
call void @__cxx_global_var_init()
%short_cond_0 = alloca i8
%count_0 = alloca i32
%i_0 = alloca i32
%ret_main_0 = alloca i32
store i32 1, ptr %i_0
br label %for.cond_0

for.cond_0:
%_5 = load i32, ptr %i_0
%_7 = load i32, ptr @N
%sle_0 = icmp sle i32 %_5, %_7
br i1 %sle_0, label %for.body_0, label %for.end_0

for.body_0:
%_10 = load ptr, ptr @b
%_12 = load i32, ptr %i_0
%arrayidx_0 = getelementptr i8, ptr %_10,i32 %_12
%frombool_0 = zext i1 true to i8
store i8 %frombool_0, ptr %arrayidx_0
br label %for.inc_0

for.inc_0:
%_16 = load i32, ptr %i_0
%inc_0 = add i32 %_16, 1
store i32 %inc_0, ptr %i_0
br label %for.cond_0

for.end_0:
store i32 2, ptr %i_0
br label %for.cond_1

for.cond_1:
%_20 = load i32, ptr %i_0
%_22 = load i32, ptr @N
%sle_1 = icmp sle i32 %_20, %_22
br i1 %sle_1, label %for.body_1, label %for.end_1

for.body_1:
%_25 = load ptr, ptr @b
%_27 = load i32, ptr %i_0
%arrayidx_1 = getelementptr i8, ptr %_25,i32 %_27
br i1 %_85, label %if.then_0, label %if.else_0

if.then_0:
store i32 2, ptr %count_0
%_30 = load i32, ptr %i_0
%sgt_0 = icmp sgt i32 %_30, 3
br i1 %sgt_0, label %short.rhs_0, label %short.quick_0

short.rhs_0:
%_34 = load i32, ptr %i_0
%sub_0 = sub i32 %_34, 2
%_37 = load ptr, ptr @b
%arrayidx_2 = getelementptr i8, ptr %_37,i32 %sub_0
%_40 = load i8, ptr %arrayidx_2
store i8 %_40, ptr %short_cond_0
br label %short.end_0

short.quick_0:
store i8 0, ptr %short_cond_0
br label %short.end_0

short.end_0:
%_42 = load i8, ptr %short_cond_0
br i1 %_64, label %if.then_1, label %if.else_1

if.then_1:
%_44 = load i32, ptr @resultCount
%inc_1 = add i32 %_44, 1
store i32 %inc_1, ptr @resultCount
%_49 = load i32, ptr %i_0
%sub_1 = sub i32 %_49, 2
%_47 = call ptr @toString(i32 %sub_1)
%_53 = call ptr @__str_add(ptr %_47, ptr @str.0)
%_58 = load i32, ptr %i_0
%_56 = call ptr @toString(i32 %_58)
%_60 = call ptr @__str_add(ptr %_53, ptr %_56)
call void @println(ptr %_60)
br label %if.end_1

if.else_1:
%_64 = trunc i8 %_42 to i1
br label %if.end_1

if.end_1:
br label %while.cond_0

while.cond_0:
%_66 = load i32, ptr %i_0
%_68 = load i32, ptr %count_0
%mul_1 = mul i32 %_66, %_68
%_71 = load i32, ptr @N
%sle_2 = icmp sle i32 %mul_1, %_71
br i1 %sle_2, label %while.body_0, label %while.end_0

while.body_0:
%_74 = load i32, ptr %i_0
%_76 = load i32, ptr %count_0
%mul_2 = mul i32 %_74, %_76
%_78 = load ptr, ptr @b
%arrayidx_3 = getelementptr i8, ptr %_78,i32 %mul_2
%frombool_1 = zext i1 false to i8
store i8 %frombool_1, ptr %arrayidx_3
%_83 = load i32, ptr %count_0
%inc_2 = add i32 %_83, 1
store i32 %inc_2, ptr %count_0
br label %while.cond_0

while.end_0:
br label %if.end_0

if.else_0:
%_86 = load i8, ptr %arrayidx_1
%_85 = trunc i8 %_86 to i1
br label %if.end_0

if.end_0:
br label %for.inc_1

for.inc_1:
%_88 = load i32, ptr %i_0
%inc_3 = add i32 %_88, 1
store i32 %inc_3, ptr %i_0
br label %for.cond_1

for.end_1:
%_93 = load i32, ptr @resultCount
%_91 = call ptr @toString(i32 %_93)
%_95 = call ptr @__str_add(ptr @str.1, ptr %_91)
call void @println(ptr %_95)
store i32 0, ptr %ret_main_0
br label %exit_main_0

exit_main_0:
%_2 = load i32, ptr %ret_main_0
ret i32 %_2

}
define dso_local void @__cxx_global_var_init() {

enter___cxx_global_var_init_0:
%mul_0 = mul i32 15001, 1
%malloc_0 = add i32 %mul_0, 4
%malloc_ptr_0 = call ptr @__malloc(i32 %malloc_0)
store i32 15001, ptr %malloc_ptr_0
%array_head_0 = getelementptr i32, ptr %malloc_ptr_0,i32 1
store ptr %array_head_0, ptr @b
br label %exit___cxx_global_var_init_0

exit___cxx_global_var_init_0:
ret void

}

