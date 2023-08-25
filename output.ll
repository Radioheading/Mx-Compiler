; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@str.0 = private unnamed_addr constant [14 x i8] c"no solution!\0A\00"
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
@N = dso_local global i32 0
@head = dso_local global i32 0
@startx = dso_local global i32 0
@starty = dso_local global i32 0
@targetx = dso_local global i32 0
@targety = dso_local global i32 0
@x = dso_local global i32 0
@y = dso_local global i32 0
@xlist = dso_local global ptr null
@ylist = dso_local global ptr null
@tail = dso_local global i32 0
@ok = dso_local global i32 0
@now = dso_local global i32 0
@dx = dso_local global ptr null
@dy = dso_local global ptr null
@step = dso_local global ptr null
@i = dso_local global i32 0
@j = dso_local global i32 0
define dso_local void @origin(i32 %N_0) {

enter_origin_0:
%N_1 = alloca i32
store i32 %N_0, ptr %N_1
store i32 0, ptr @head
store i32 0, ptr @tail
%_11 = load i32, ptr %N_1
%mul_4 = mul i32 %_11, 4
%malloc_4 = add i32 %mul_4, 4
%malloc_ptr_4 = call ptr @__malloc(i32 %malloc_4)
store i32 %_11, ptr %malloc_ptr_4
%array_head_4 = getelementptr i32, ptr %malloc_ptr_4,i32 1
store ptr %array_head_4, ptr @step
store i32 0, ptr @i
br label %for.cond_0

for.cond_0:
%_15 = load i32, ptr @i
%_17 = load i32, ptr %N_1
%slt_0 = icmp slt i32 %_15, %_17
br i1 %slt_0, label %for.body_0, label %for.end_0

for.inc_0:
%_20 = load i32, ptr @i
%inc_0 = add i32 %_20, 1
store i32 %inc_0, ptr @i
br label %for.cond_0

for.body_0:
%_23 = load ptr, ptr @step
%_25 = load i32, ptr @i
%arrayidx_0 = getelementptr ptr, ptr %_23,i32 %_25
%_27 = load i32, ptr %N_1
%mul_5 = mul i32 %_27, 4
%malloc_5 = add i32 %mul_5, 4
%malloc_ptr_5 = call ptr @__malloc(i32 %malloc_5)
store i32 %_27, ptr %malloc_ptr_5
%array_head_5 = getelementptr i32, ptr %malloc_ptr_5,i32 1
store ptr %array_head_5, ptr %arrayidx_0
store i32 0, ptr @j
br label %for.cond_1

for.cond_1:
%_31 = load i32, ptr @j
%_33 = load i32, ptr %N_1
%slt_1 = icmp slt i32 %_31, %_33
br i1 %slt_1, label %for.body_1, label %for.end_1

for.inc_1:
%_36 = load i32, ptr @j
%inc_1 = add i32 %_36, 1
store i32 %inc_1, ptr @j
br label %for.cond_1

for.body_1:
%_39 = load ptr, ptr @step
%_41 = load i32, ptr @i
%arrayidx_1 = getelementptr ptr, ptr %_39,i32 %_41
%_43 = load ptr, ptr %arrayidx_1
%_45 = load i32, ptr @j
%arrayidx_2 = getelementptr i32, ptr %_43,i32 %_45
store i32 0, ptr %arrayidx_2
br label %for.inc_1

for.end_1:
br label %for.inc_0

for.end_0:
br label %exit_origin_0

exit_origin_0:
ret void

}
define dso_local i8 @check(i32 %a_0) {

enter_check_0:
%short_cond_0 = alloca i8
%ret_check_0 = alloca i8
%a_1 = alloca i32
store i32 %a_0, ptr %a_1
%_49 = load i32, ptr %a_1
%_51 = load i32, ptr @N
%slt_2 = icmp slt i32 %_49, %_51
br i1 %slt_2, label %short.rhs_0, label %short.quick_0

short.rhs_0:
%_54 = load i32, ptr %a_1
%sge_0 = icmp sge i32 %_54, 0
%frombool_0 = zext i1 %sge_0 to i8
store i8 %frombool_0, ptr %short_cond_0
br label %short.end_0

short.quick_0:
store i8 0, ptr %short_cond_0
br label %short.end_0

short.end_0:
%_59 = load i8, ptr %short_cond_0
store i8 %_59, ptr %ret_check_0
br label %exit_check_0

exit_check_0:
%_47 = load i8, ptr %ret_check_0
ret i8 %_47

}
define dso_local void @addList(i32 %x_0,i32 %y_0) {

enter_addList_0:
%short_cond_3 = alloca i8
%short_cond_2 = alloca i8
%short_cond_1 = alloca i8
%y_1 = alloca i32
%x_1 = alloca i32
store i32 %x_0, ptr %x_1
store i32 %y_0, ptr %y_1
%_63 = load i32, ptr %x_1
%_61 = call i8 @check(i32 %_63)
%_64 = trunc i8 %_61 to i1
br i1 %_64, label %short.rhs_1, label %short.quick_1

short.rhs_1:
%_67 = load i32, ptr %y_1
%_65 = call i8 @check(i32 %_67)
store i8 %_65, ptr %short_cond_1
br label %short.end_1

short.quick_1:
store i8 0, ptr %short_cond_1
br label %short.end_1

short.end_1:
%_70 = load i8, ptr %short_cond_1
%_71 = trunc i8 %_70 to i1
br i1 %_71, label %short.rhs_2, label %short.quick_2

short.rhs_2:
%_73 = load ptr, ptr @step
%_75 = load i32, ptr %x_1
%arrayidx_3 = getelementptr ptr, ptr %_73,i32 %_75
%_77 = load ptr, ptr %arrayidx_3
%_79 = load i32, ptr %y_1
%arrayidx_4 = getelementptr i32, ptr %_77,i32 %_79
%minus_0 = sub i32 0, 1
%_83 = load i32, ptr %arrayidx_4
%_85 = icmp eq i32 %_83, %minus_0
%frombool_1 = zext i1 %_85 to i8
store i8 %frombool_1, ptr %short_cond_2
br label %short.end_2

short.quick_2:
store i8 0, ptr %short_cond_2
br label %short.end_2

short.end_2:
%_89 = load i8, ptr %short_cond_2
%_136 = trunc i8 %_89 to i1
br i1 %_136, label %if.then_0, label %if.end_0

if.then_0:
%_91 = load i32, ptr @tail
%inc_2 = add i32 %_91, 1
store i32 %inc_2, ptr @tail
%_94 = load ptr, ptr @xlist
%_96 = load i32, ptr @tail
%arrayidx_5 = getelementptr i32, ptr %_94,i32 %_96
%_98 = load i32, ptr %x_1
store i32 %_98, ptr %arrayidx_5
%_100 = load ptr, ptr @ylist
%_102 = load i32, ptr @tail
%arrayidx_6 = getelementptr i32, ptr %_100,i32 %_102
%_104 = load i32, ptr %y_1
store i32 %_104, ptr %arrayidx_6
%_106 = load ptr, ptr @step
%_108 = load i32, ptr %x_1
%arrayidx_7 = getelementptr ptr, ptr %_106,i32 %_108
%_110 = load ptr, ptr %arrayidx_7
%_112 = load i32, ptr %y_1
%arrayidx_8 = getelementptr i32, ptr %_110,i32 %_112
%_114 = load i32, ptr @now
%add_0 = add i32 %_114, 1
store i32 %add_0, ptr %arrayidx_8
%_119 = load i32, ptr %x_1
%_121 = load i32, ptr @targetx
%_122 = icmp eq i32 %_119, %_121
br i1 %_122, label %short.rhs_3, label %short.quick_3

short.rhs_3:
%_126 = load i32, ptr %y_1
%_128 = load i32, ptr @targety
%_129 = icmp eq i32 %_126, %_128
%frombool_2 = zext i1 %_129 to i8
store i8 %frombool_2, ptr %short_cond_3
br label %short.end_3

short.quick_3:
store i8 0, ptr %short_cond_3
br label %short.end_3

short.end_3:
%_133 = load i8, ptr %short_cond_3
%_135 = trunc i8 %_133 to i1
br i1 %_135, label %if.then_1, label %if.end_1

if.then_1:
store i32 1, ptr @ok
br label %if.end_1

if.end_1:
br label %if.end_0

if.end_0:
br label %exit_addList_0

exit_addList_0:
ret void

}
define dso_local i32 @main() {

enter_main_0:
%ret_main_0 = alloca i32
store i32 0, ptr %ret_main_0
call void @__mx_global_var_init()
call void @origin(i32 106)
%_140 = call i32 @getInt()
store i32 %_140, ptr @N
%_143 = load i32, ptr @N
%sub_0 = sub i32 %_143, 1
store i32 %sub_0, ptr @targety
%_147 = load i32, ptr @targety
store i32 %_147, ptr @targetx
store i32 0, ptr @i
br label %for.cond_2

for.cond_2:
%_150 = load i32, ptr @i
%_152 = load i32, ptr @N
%slt_3 = icmp slt i32 %_150, %_152
br i1 %slt_3, label %for.body_2, label %for.end_2

for.inc_2:
%_155 = load i32, ptr @i
%inc_3 = add i32 %_155, 1
store i32 %inc_3, ptr @i
br label %for.cond_2

for.body_2:
store i32 0, ptr @j
br label %for.cond_3

for.cond_3:
%_159 = load i32, ptr @j
%_161 = load i32, ptr @N
%slt_4 = icmp slt i32 %_159, %_161
br i1 %slt_4, label %for.body_3, label %for.end_3

for.inc_3:
%_164 = load i32, ptr @j
%inc_4 = add i32 %_164, 1
store i32 %inc_4, ptr @j
br label %for.cond_3

for.body_3:
%_167 = load ptr, ptr @step
%_169 = load i32, ptr @i
%arrayidx_9 = getelementptr ptr, ptr %_167,i32 %_169
%_171 = load ptr, ptr %arrayidx_9
%_173 = load i32, ptr @j
%arrayidx_10 = getelementptr i32, ptr %_171,i32 %_173
%minus_1 = sub i32 0, 1
store i32 %minus_1, ptr %arrayidx_10
br label %for.inc_3

for.end_3:
br label %for.inc_2

for.end_2:
%_177 = load ptr, ptr @dx
%arrayidx_11 = getelementptr i32, ptr %_177,i32 0
%minus_2 = sub i32 0, 2
store i32 %minus_2, ptr %arrayidx_11
%_182 = load ptr, ptr @dy
%arrayidx_12 = getelementptr i32, ptr %_182,i32 0
%minus_3 = sub i32 0, 1
store i32 %minus_3, ptr %arrayidx_12
%_187 = load ptr, ptr @dx
%arrayidx_13 = getelementptr i32, ptr %_187,i32 1
%minus_4 = sub i32 0, 2
store i32 %minus_4, ptr %arrayidx_13
%_192 = load ptr, ptr @dy
%arrayidx_14 = getelementptr i32, ptr %_192,i32 1
store i32 1, ptr %arrayidx_14
%_196 = load ptr, ptr @dx
%arrayidx_15 = getelementptr i32, ptr %_196,i32 2
store i32 2, ptr %arrayidx_15
%_200 = load ptr, ptr @dy
%arrayidx_16 = getelementptr i32, ptr %_200,i32 2
%minus_5 = sub i32 0, 1
store i32 %minus_5, ptr %arrayidx_16
%_205 = load ptr, ptr @dx
%arrayidx_17 = getelementptr i32, ptr %_205,i32 3
store i32 2, ptr %arrayidx_17
%_209 = load ptr, ptr @dy
%arrayidx_18 = getelementptr i32, ptr %_209,i32 3
store i32 1, ptr %arrayidx_18
%_213 = load ptr, ptr @dx
%arrayidx_19 = getelementptr i32, ptr %_213,i32 4
%minus_6 = sub i32 0, 1
store i32 %minus_6, ptr %arrayidx_19
%_218 = load ptr, ptr @dy
%arrayidx_20 = getelementptr i32, ptr %_218,i32 4
%minus_7 = sub i32 0, 2
store i32 %minus_7, ptr %arrayidx_20
%_223 = load ptr, ptr @dx
%arrayidx_21 = getelementptr i32, ptr %_223,i32 5
%minus_8 = sub i32 0, 1
store i32 %minus_8, ptr %arrayidx_21
%_228 = load ptr, ptr @dy
%arrayidx_22 = getelementptr i32, ptr %_228,i32 5
store i32 2, ptr %arrayidx_22
%_232 = load ptr, ptr @dx
%arrayidx_23 = getelementptr i32, ptr %_232,i32 6
store i32 1, ptr %arrayidx_23
%_236 = load ptr, ptr @dy
%arrayidx_24 = getelementptr i32, ptr %_236,i32 6
%minus_9 = sub i32 0, 2
store i32 %minus_9, ptr %arrayidx_24
%_241 = load ptr, ptr @dx
%arrayidx_25 = getelementptr i32, ptr %_241,i32 7
store i32 1, ptr %arrayidx_25
%_245 = load ptr, ptr @dy
%arrayidx_26 = getelementptr i32, ptr %_245,i32 7
store i32 2, ptr %arrayidx_26
br label %while.cond_0

while.cond_0:
%_249 = load i32, ptr @head
%_251 = load i32, ptr @tail
%sle_0 = icmp sle i32 %_249, %_251
br i1 %sle_0, label %while.body_0, label %while.end_0

while.body_0:
%_254 = load ptr, ptr @xlist
%_256 = load i32, ptr @head
%arrayidx_27 = getelementptr i32, ptr %_254,i32 %_256
%_258 = load i32, ptr %arrayidx_27
store i32 %_258, ptr @x
%_260 = load ptr, ptr @ylist
%_262 = load i32, ptr @head
%arrayidx_28 = getelementptr i32, ptr %_260,i32 %_262
%_264 = load i32, ptr %arrayidx_28
store i32 %_264, ptr @y
%_266 = load ptr, ptr @step
%_268 = load i32, ptr @x
%arrayidx_29 = getelementptr ptr, ptr %_266,i32 %_268
%_270 = load ptr, ptr %arrayidx_29
%_272 = load i32, ptr @y
%arrayidx_30 = getelementptr i32, ptr %_270,i32 %_272
%_274 = load i32, ptr %arrayidx_30
store i32 %_274, ptr @now
store i32 0, ptr @j
br label %for.cond_4

for.cond_4:
%_277 = load i32, ptr @j
%slt_5 = icmp slt i32 %_277, 8
br i1 %slt_5, label %for.body_4, label %for.end_4

for.inc_4:
%_281 = load i32, ptr @j
%inc_5 = add i32 %_281, 1
store i32 %inc_5, ptr @j
br label %for.cond_4

for.body_4:
%_285 = load ptr, ptr @dx
%_287 = load i32, ptr @j
%arrayidx_31 = getelementptr i32, ptr %_285,i32 %_287
%_289 = load i32, ptr @x
%_291 = load i32, ptr %arrayidx_31
%add_1 = add i32 %_289, %_291
%_293 = load ptr, ptr @dy
%_295 = load i32, ptr @j
%arrayidx_32 = getelementptr i32, ptr %_293,i32 %_295
%_297 = load i32, ptr @y
%_299 = load i32, ptr %arrayidx_32
%add_2 = add i32 %_297, %_299
call void @addList(i32 %add_1, i32 %add_2)
br label %for.inc_4

for.end_4:
%_304 = load i32, ptr @ok
%_306 = icmp eq i32 %_304, 1
br i1 %_306, label %if.then_2, label %if.end_2

if.then_2:
br label %while.end_0

if.end_2:
%_309 = load i32, ptr @head
%inc_6 = add i32 %_309, 1
store i32 %inc_6, ptr @head
br label %while.cond_0

while.end_0:
%_313 = load i32, ptr @ok
%_315 = icmp eq i32 %_313, 1
br i1 %_315, label %if.then_3, label %if.else_3

if.then_3:
%_319 = load ptr, ptr @step
%_321 = load i32, ptr @targetx
%arrayidx_33 = getelementptr ptr, ptr %_319,i32 %_321
%_323 = load ptr, ptr %arrayidx_33
%_325 = load i32, ptr @targety
%arrayidx_34 = getelementptr i32, ptr %_323,i32 %_325
%_327 = load i32, ptr %arrayidx_34
%_317 = call ptr @toString(i32 %_327)
call void @println(ptr %_317)
br label %if.end_3

if.else_3:
call void @print(ptr @str.0)
br label %if.end_3

if.end_3:
store i32 0, ptr %ret_main_0
br label %exit_main_0

exit_main_0:
%_137 = load i32, ptr %ret_main_0
ret i32 %_137

}
define dso_local void @__mx_global_var_init() {

enter___mx_global_var_init_0:
%mul_0 = mul i32 12000, 4
%malloc_0 = add i32 %mul_0, 4
%malloc_ptr_0 = call ptr @__malloc(i32 %malloc_0)
store i32 12000, ptr %malloc_ptr_0
%array_head_0 = getelementptr i32, ptr %malloc_ptr_0,i32 1
store ptr %array_head_0, ptr @xlist
%mul_1 = mul i32 12000, 4
%malloc_1 = add i32 %mul_1, 4
%malloc_ptr_1 = call ptr @__malloc(i32 %malloc_1)
store i32 12000, ptr %malloc_ptr_1
%array_head_1 = getelementptr i32, ptr %malloc_ptr_1,i32 1
store ptr %array_head_1, ptr @ylist
%mul_2 = mul i32 8, 4
%malloc_2 = add i32 %mul_2, 4
%malloc_ptr_2 = call ptr @__malloc(i32 %malloc_2)
store i32 8, ptr %malloc_ptr_2
%array_head_2 = getelementptr i32, ptr %malloc_ptr_2,i32 1
store ptr %array_head_2, ptr @dx
%mul_3 = mul i32 9, 4
%malloc_3 = add i32 %mul_3, 4
%malloc_ptr_3 = call ptr @__malloc(i32 %malloc_3)
store i32 9, ptr %malloc_ptr_3
%array_head_3 = getelementptr i32, ptr %malloc_ptr_3,i32 1
store ptr %array_head_3, ptr @dy
br label %exit___mx_global_var_init_0

exit___mx_global_var_init_0:
ret void

}

