; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
declare void @print(ptr)
declare void @println(ptr)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare ptr @getString()
declare i32 @getInt()
declare ptr @toString(i32)
declare ptr @__malloc(i32)
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
@a = dso_local global ptr null
@i = dso_local global i32 0
define dso_local i32 @jud(i32 %x_4) {

enter_jud_0:
%flag_28 = alloca i8
%j_16 = alloca i32
%i_15 = alloca i32
%ret_jud_3 = alloca i32
%x_13 = alloca i32
store i32 %x_4, ptr %x_13
store i32 0, ptr %i_15
br label %for.cond_0

for.cond_0:
%_20 = load i32, ptr @n
%_22 = load i32, ptr %x_13
%sdiv_18 = sdiv i32 %_20, %_22
%_25 = load i32, ptr %i_15
%slt_23 = icmp slt i32 %_25, %sdiv_18
br i1 %slt_23, label %for.body_0, label %for.end_0

for.body_0:
store i1 false, ptr %flag_28
store i32 0, ptr %j_16
br label %for.cond_1

for.cond_1:
%_32 = load i32, ptr %x_13
%sub_30 = sub i32 %_32, 1
%_36 = load i32, ptr %j_16
%slt_34 = icmp slt i32 %_36, %sub_30
br i1 %slt_34, label %for.body_1, label %for.end_1

for.body_1:
%_41 = load i32, ptr %i_15
%_43 = load i32, ptr %x_13
%mul_39 = mul i32 %_41, %_43
%_47 = load i32, ptr %j_16
%add_44 = add i32 %mul_39, %_47
%_49 = load ptr, ptr @a
%arrayidx_50 = getelementptr i32, ptr %_49,i32 %add_44
%_54 = load i32, ptr %i_15
%_56 = load i32, ptr %x_13
%mul_52 = mul i32 %_54, %_56
%_60 = load i32, ptr %j_16
%add_57 = add i32 %mul_52, %_60
%add_61 = add i32 %add_57, 1
%_65 = load ptr, ptr @a
%arrayidx_66 = getelementptr i32, ptr %_65,i32 %add_61
%_70 = load i32, ptr %arrayidx_50
%_72 = load i32, ptr %arrayidx_66
%sgt_68 = icmp sgt i32 %_70, %_72
br i1 %sgt_68, label %if.then_0, label %if.else_0

if.then_0:
%frombool_74 = zext i1 true to i8
store i8 %frombool_74, ptr %flag_28
br label %if.end_0

if.else_0:
br label %if.end_0

if.end_0:
br label %for.inc_1

for.inc_1:
%_80 = load i32, ptr %j_16
%inc_78 = add i32 %_80, 1
store i32 %inc_78, ptr %j_16
br label %for.cond_1

for.end_1:
%_84 = load i8, ptr %flag_28
%_83 = trunc i8 %_84 to i1
%lnot_82 = xor i1 true, %_83
br i1 %lnot_82, label %if.then_1, label %if.else_1

if.then_1:
store i32 1, ptr %ret_jud_3
br label %exit_jud_0

if.else_1:
br label %if.end_1

if.end_1:
br label %for.inc_0

for.inc_0:
%_90 = load i32, ptr %i_15
%inc_88 = add i32 %_90, 1
store i32 %inc_88, ptr %i_15
br label %for.cond_0

for.end_0:
store i32 0, ptr %ret_jud_3
br label %exit_jud_0

exit_jud_0:
%_14 = load i32, ptr %ret_jud_3
ret i32 %_14

}
define dso_local i32 @main() {

enter_main_0:
call void @__cxx_global_var_init()
%ret_main_5 = alloca i32
%_94 = call i32 @getInt()
store i32 %_94, ptr @n
store i32 0, ptr @i
br label %for.cond_2

for.cond_2:
%_99 = load i32, ptr @i
%_101 = load i32, ptr @n
%slt_97 = icmp slt i32 %_99, %_101
br i1 %slt_97, label %for.body_2, label %for.end_2

for.body_2:
%_104 = load ptr, ptr @a
%_107 = load i32, ptr @i
%arrayidx_105 = getelementptr i32, ptr %_104,i32 %_107
%_108 = call i32 @getInt()
store i32 %_108, ptr %arrayidx_105
br label %for.inc_2

for.inc_2:
%_112 = load i32, ptr @i
%inc_110 = add i32 %_112, 1
store i32 %inc_110, ptr @i
br label %for.cond_2

for.end_2:
%_115 = load i32, ptr @n
store i32 %_115, ptr @i
br label %for.cond_3

for.cond_3:
%_118 = load i32, ptr @i
%sgt_116 = icmp sgt i32 %_118, 0
br i1 %sgt_116, label %for.body_3, label %for.end_3

for.body_3:
%_123 = load i32, ptr @i
%_121 = call i32 @jud(i32 %_123)
%sgt_124 = icmp sgt i32 %_121, 0
br i1 %sgt_124, label %if.then_2, label %if.else_2

if.then_2:
%_130 = load i32, ptr @i
%_128 = call ptr @toString(i32 %_130)
call void @print(ptr %_128)
store i32 0, ptr %ret_main_5
br label %exit_main_0

if.else_2:
br label %if.end_2

if.end_2:
br label %for.inc_3

for.inc_3:
%_137 = load i32, ptr @i
%sdiv_135 = sdiv i32 %_137, 2
store i32 %sdiv_135, ptr @i
br label %for.cond_3

for.end_3:
store i32 0, ptr %ret_main_5
br label %exit_main_0

exit_main_0:
%_93 = load i32, ptr %ret_main_5
ret i32 %_93

}
define dso_local void @__cxx_global_var_init() {

enter___cxx_global_var_init_0:
%mul_8 = mul i32 20, 4
%malloc_9 = add i32 %mul_8, 4
%malloc_ptr_10 = call ptr @__malloc(i32 %malloc_9)
store i32 20, ptr %malloc_ptr_10
%array_head_11 = getelementptr i32, ptr %malloc_ptr_10,i32 1
store ptr %array_head_11, ptr @a
br label %exit___cxx_global_var_init_0

exit___cxx_global_var_init_0:
ret void

}

