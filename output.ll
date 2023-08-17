; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@str.0 = private unnamed_addr constant [2 x i8] c" \00"
@str.1 = private unnamed_addr constant [2 x i8] c"\0A\00"
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
@a = dso_local global ptr null
define dso_local void @exchange(i32 %x_0,i32 %y_0) {

enter_exchange_0:
%t_0 = alloca i32
%y_1 = alloca i32
%x_1 = alloca i32
store i32 %x_0, ptr %x_1
store i32 %y_0, ptr %y_1
%_1 = load ptr, ptr @a
%_3 = load i32, ptr %x_1
%arrayidx_0 = getelementptr i32, ptr %_1,i32 %_3
%_5 = load i32, ptr %arrayidx_0
store i32 %_5, ptr %t_0
%_7 = load ptr, ptr @a
%_9 = load i32, ptr %x_1
%arrayidx_1 = getelementptr i32, ptr %_7,i32 %_9
%_11 = load ptr, ptr @a
%_13 = load i32, ptr %y_1
%arrayidx_2 = getelementptr i32, ptr %_11,i32 %_13
%_15 = load i32, ptr %arrayidx_2
store i32 %_15, ptr %arrayidx_1
%_17 = load ptr, ptr @a
%_19 = load i32, ptr %y_1
%arrayidx_3 = getelementptr i32, ptr %_17,i32 %_19
%_21 = load i32, ptr %t_0
store i32 %_21, ptr %arrayidx_3
br label %exit_exchange_0

exit_exchange_0:
ret void

}
define dso_local i32 @makeHeap() {

enter_makeHeap_0:
%short_cond_0 = alloca i8
%j_0 = alloca i32
%t_1 = alloca i32
%i_0 = alloca i32
%ret_makeHeap_0 = alloca i32
%_24 = load i32, ptr @n
%sub_0 = sub i32 %_24, 1
%sdiv_0 = sdiv i32 %sub_0, 2
store i32 %sdiv_0, ptr %i_0
store i32 0, ptr %t_1
store i32 0, ptr %j_0
br label %while.cond_0

while.cond_0:
%_32 = load i32, ptr %i_0
%sge_0 = icmp sge i32 %_32, 0
br i1 %sge_0, label %while.body_0, label %while.end_0

while.body_0:
%_36 = load i32, ptr %i_0
%mul_0 = mul i32 %_36, 2
store i32 %mul_0, ptr %j_0
%_40 = load i32, ptr %i_0
%mul_1 = mul i32 %_40, 2
%add_0 = add i32 %mul_1, 1
%_46 = load i32, ptr @n
%slt_0 = icmp slt i32 %add_0, %_46
br i1 %slt_0, label %short.rhs_0, label %short.quick_0

short.rhs_0:
%_49 = load i32, ptr %i_0
%mul_2 = mul i32 %_49, 2
%add_1 = add i32 %mul_2, 1
%_54 = load ptr, ptr @a
%arrayidx_4 = getelementptr i32, ptr %_54,i32 %add_1
%_57 = load i32, ptr %i_0
%mul_3 = mul i32 %_57, 2
%_60 = load ptr, ptr @a
%arrayidx_5 = getelementptr i32, ptr %_60,i32 %mul_3
%_63 = load i32, ptr %arrayidx_4
%_65 = load i32, ptr %arrayidx_5
%slt_1 = icmp slt i32 %_63, %_65
%frombool_0 = zext i1 %slt_1 to i8
store i8 %frombool_0, ptr %short_cond_0
br label %short.end_0

short.quick_0:
store i8 0, ptr %short_cond_0
br label %short.end_0

short.end_0:
%_69 = load i8, ptr %short_cond_0
%_76 = trunc i8 %_69 to i1
br i1 %_76, label %if.then_0, label %if.end_0

if.then_0:
%_71 = load i32, ptr %i_0
%mul_4 = mul i32 %_71, 2
%add_2 = add i32 %mul_4, 1
store i32 %add_2, ptr %j_0
br label %if.end_0

if.end_0:
%_78 = load ptr, ptr @a
%_80 = load i32, ptr %i_0
%arrayidx_6 = getelementptr i32, ptr %_78,i32 %_80
%_82 = load ptr, ptr @a
%_84 = load i32, ptr %j_0
%arrayidx_7 = getelementptr i32, ptr %_82,i32 %_84
%_86 = load i32, ptr %arrayidx_6
%_88 = load i32, ptr %arrayidx_7
%sgt_0 = icmp sgt i32 %_86, %_88
br i1 %sgt_0, label %if.then_1, label %if.end_1

if.then_1:
%_91 = load i32, ptr %i_0
%_93 = load i32, ptr %j_0
call void @exchange(i32 %_91, i32 %_93)
br label %if.end_1

if.end_1:
%_96 = load i32, ptr %i_0
%sub_1 = sub i32 %_96, 1
store i32 %sub_1, ptr %i_0
br label %while.cond_0

while.end_0:
store i32 0, ptr %ret_makeHeap_0
br label %exit_makeHeap_0

exit_makeHeap_0:
%_22 = load i32, ptr %ret_makeHeap_0
ret i32 %_22

}
define dso_local i32 @adjustHeap(i32 %n_0) {

enter_adjustHeap_0:
%t_3 = alloca i32
%short_cond_1 = alloca i8
%t_2 = alloca i32
%j_1 = alloca i32
%i_1 = alloca i32
%ret_adjustHeap_0 = alloca i32
%n_1 = alloca i32
store i32 %n_0, ptr %n_1
store i32 0, ptr %i_1
store i32 0, ptr %j_1
store i32 0, ptr %t_2
br label %while.cond_1

while.cond_1:
%_105 = load i32, ptr %i_1
%mul_5 = mul i32 %_105, 2
%_109 = load i32, ptr %n_1
%slt_2 = icmp slt i32 %mul_5, %_109
br i1 %slt_2, label %while.body_1, label %while.end_1

while.body_1:
%_112 = load i32, ptr %i_1
%mul_6 = mul i32 %_112, 2
store i32 %mul_6, ptr %j_1
%_116 = load i32, ptr %i_1
%mul_7 = mul i32 %_116, 2
%add_3 = add i32 %mul_7, 1
%_122 = load i32, ptr %n_1
%slt_3 = icmp slt i32 %add_3, %_122
br i1 %slt_3, label %short.rhs_1, label %short.quick_1

short.rhs_1:
%_125 = load i32, ptr %i_1
%mul_8 = mul i32 %_125, 2
%add_4 = add i32 %mul_8, 1
%_130 = load ptr, ptr @a
%arrayidx_8 = getelementptr i32, ptr %_130,i32 %add_4
%_133 = load i32, ptr %i_1
%mul_9 = mul i32 %_133, 2
%_136 = load ptr, ptr @a
%arrayidx_9 = getelementptr i32, ptr %_136,i32 %mul_9
%_139 = load i32, ptr %arrayidx_8
%_141 = load i32, ptr %arrayidx_9
%slt_4 = icmp slt i32 %_139, %_141
%frombool_1 = zext i1 %slt_4 to i8
store i8 %frombool_1, ptr %short_cond_1
br label %short.end_1

short.quick_1:
store i8 0, ptr %short_cond_1
br label %short.end_1

short.end_1:
%_145 = load i8, ptr %short_cond_1
%_152 = trunc i8 %_145 to i1
br i1 %_152, label %if.then_2, label %if.end_2

if.then_2:
%_147 = load i32, ptr %i_1
%mul_10 = mul i32 %_147, 2
%add_5 = add i32 %mul_10, 1
store i32 %add_5, ptr %j_1
br label %if.end_2

if.end_2:
%_154 = load ptr, ptr @a
%_156 = load i32, ptr %i_1
%arrayidx_10 = getelementptr i32, ptr %_154,i32 %_156
%_158 = load ptr, ptr @a
%_160 = load i32, ptr %j_1
%arrayidx_11 = getelementptr i32, ptr %_158,i32 %_160
%_162 = load i32, ptr %arrayidx_10
%_164 = load i32, ptr %arrayidx_11
%sgt_1 = icmp sgt i32 %_162, %_164
br i1 %sgt_1, label %if.then_3, label %if.else_3

if.then_3:
%_166 = load ptr, ptr @a
%_168 = load i32, ptr %i_1
%arrayidx_12 = getelementptr i32, ptr %_166,i32 %_168
%_170 = load i32, ptr %arrayidx_12
store i32 %_170, ptr %t_3
%_172 = load ptr, ptr @a
%_174 = load i32, ptr %i_1
%arrayidx_13 = getelementptr i32, ptr %_172,i32 %_174
%_176 = load ptr, ptr @a
%_178 = load i32, ptr %j_1
%arrayidx_14 = getelementptr i32, ptr %_176,i32 %_178
%_180 = load i32, ptr %arrayidx_14
store i32 %_180, ptr %arrayidx_13
%_182 = load ptr, ptr @a
%_184 = load i32, ptr %j_1
%arrayidx_15 = getelementptr i32, ptr %_182,i32 %_184
%_186 = load i32, ptr %t_3
store i32 %_186, ptr %arrayidx_15
%_188 = load i32, ptr %j_1
store i32 %_188, ptr %i_1
br label %if.end_3

if.else_3:
br label %while.end_1

if.end_3:
br label %while.cond_1

while.end_1:
store i32 0, ptr %ret_adjustHeap_0
br label %exit_adjustHeap_0

exit_adjustHeap_0:
%_100 = load i32, ptr %ret_adjustHeap_0
ret i32 %_100

}
define dso_local i32 @heapSort() {

enter_heapSort_0:
%k_0 = alloca i32
%t_4 = alloca i32
%ret_heapSort_0 = alloca i32
store i32 0, ptr %t_4
store i32 0, ptr %k_0
br label %for.cond_0

for.cond_0:
%_195 = load i32, ptr %k_0
%_197 = load i32, ptr @n
%slt_5 = icmp slt i32 %_195, %_197
br i1 %slt_5, label %for.body_0, label %for.end_0

for.inc_0:
%_200 = load i32, ptr %k_0
%add_6 = add i32 %_200, 1
store i32 %add_6, ptr %k_0
br label %for.cond_0

for.body_0:
%_204 = load ptr, ptr @a
%arrayidx_16 = getelementptr i32, ptr %_204,i32 0
%_207 = load i32, ptr %arrayidx_16
store i32 %_207, ptr %t_4
%_209 = load ptr, ptr @a
%arrayidx_17 = getelementptr i32, ptr %_209,i32 0
%_212 = load i32, ptr @n
%_214 = load i32, ptr %k_0
%sub_2 = sub i32 %_212, %_214
%sub_3 = sub i32 %sub_2, 1
%_218 = load ptr, ptr @a
%arrayidx_18 = getelementptr i32, ptr %_218,i32 %sub_3
%_221 = load i32, ptr %arrayidx_18
store i32 %_221, ptr %arrayidx_17
%_223 = load i32, ptr @n
%_225 = load i32, ptr %k_0
%sub_4 = sub i32 %_223, %_225
%sub_5 = sub i32 %sub_4, 1
%_229 = load ptr, ptr @a
%arrayidx_19 = getelementptr i32, ptr %_229,i32 %sub_5
%_232 = load i32, ptr %t_4
store i32 %_232, ptr %arrayidx_19
%_235 = load i32, ptr @n
%_237 = load i32, ptr %k_0
%sub_6 = sub i32 %_235, %_237
%sub_7 = sub i32 %sub_6, 1
%_233 = call i32 @adjustHeap(i32 %sub_7)
br label %for.inc_0

for.end_0:
store i32 0, ptr %ret_heapSort_0
br label %exit_heapSort_0

exit_heapSort_0:
%_191 = load i32, ptr %ret_heapSort_0
ret i32 %_191

}
define dso_local i32 @main() {

enter_main_0:
store i32 0, ptr %ret_main_0
call void @__cxx_global_var_init()
%i_2 = alloca i32
%ret_main_0 = alloca i32
%_243 = call ptr @getString()
%_244 = call i32 @__str_parseInt(ptr %_243)
store i32 %_244, ptr @n
%_248 = load i32, ptr @n
%mul_11 = mul i32 %_248, 4
%malloc_0 = add i32 %mul_11, 4
%malloc_ptr_0 = call ptr @__malloc(i32 %malloc_0)
store i32 %_248, ptr %malloc_ptr_0
%array_head_0 = getelementptr i32, ptr %malloc_ptr_0,i32 1
store ptr %array_head_0, ptr @a
store i32 0, ptr %i_2
br label %for.cond_1

for.cond_1:
%_253 = load ptr, ptr @a
%_251 = call i32 @__array_size(ptr %_253)
%_255 = load i32, ptr %i_2
%slt_6 = icmp slt i32 %_255, %_251
br i1 %slt_6, label %for.body_1, label %for.end_1

for.inc_1:
%_259 = load i32, ptr %i_2
%add_7 = add i32 %_259, 1
store i32 %add_7, ptr %i_2
br label %for.cond_1

for.body_1:
%_263 = load ptr, ptr @a
%_265 = load i32, ptr %i_2
%arrayidx_20 = getelementptr i32, ptr %_263,i32 %_265
%_267 = load i32, ptr %i_2
store i32 %_267, ptr %arrayidx_20
br label %for.inc_1

for.end_1:
%_268 = call i32 @makeHeap()
%_269 = call i32 @heapSort()
store i32 0, ptr %i_2
br label %for.cond_2

for.cond_2:
%_273 = load ptr, ptr @a
%_271 = call i32 @__array_size(ptr %_273)
%_275 = load i32, ptr %i_2
%slt_7 = icmp slt i32 %_275, %_271
br i1 %slt_7, label %for.body_2, label %for.end_2

for.inc_2:
%_279 = load i32, ptr %i_2
%add_8 = add i32 %_279, 1
store i32 %add_8, ptr %i_2
br label %for.cond_2

for.body_2:
%_285 = load ptr, ptr @a
%_287 = load i32, ptr %i_2
%arrayidx_21 = getelementptr i32, ptr %_285,i32 %_287
%_289 = load i32, ptr %arrayidx_21
%_283 = call ptr @toString(i32 %_289)
%_291 = call ptr @__str_add(ptr %_283, ptr @str.0)
call void @print(ptr %_291)
br label %for.inc_2

for.end_2:
call void @print(ptr @str.1)
store i32 0, ptr %ret_main_0
br label %exit_main_0

exit_main_0:
%_242 = load i32, ptr %ret_main_0
ret i32 %_242

}
define dso_local void @__cxx_global_var_init() {

enter___cxx_global_var_init_0:
br label %exit___cxx_global_var_init_0

exit___cxx_global_var_init_0:
ret void

}

