; ModuleID = 'for-test.c'
source_filename = "for-test.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
%struct.vector = type {ptr}
@str.3 = private unnamed_addr constant [11 x i8] c"vector x: \00"
@str.5 = private unnamed_addr constant [11 x i8] c"vector y: \00"
@str.1 = private unnamed_addr constant [3 x i8] c", \00"
@str.7 = private unnamed_addr constant [8 x i8] c"x * y: \00"
@str.4 = private unnamed_addr constant [9 x i8] c"excited!\00"
@str.6 = private unnamed_addr constant [8 x i8] c"x + y: \00"
@str.0 = private unnamed_addr constant [3 x i8] c"( \00"
@str.2 = private unnamed_addr constant [3 x i8] c" )\00"
@str.8 = private unnamed_addr constant [15 x i8] c"(1 << 3) * y: \00"
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
define dso_local void @vector__init(ptr %this_0,ptr %vec_0) {

enter_init_0:
%i_0 = alloca i32
%vec_1 = alloca ptr
%this.addr_0 = alloca ptr
store ptr %this_0, ptr %this.addr_0
store ptr %vec_0, ptr %vec_1
%_2 = load ptr, ptr %vec_1
%_4 = icmp eq ptr %_2, null
br i1 %_4, label %if.then_0, label %if.end_0

if.then_0:
br label %exit_init_0

if.end_0:
%this_8 = load ptr, ptr %this.addr_0
%this.data_0 = getelementptr %struct.vector, ptr %this_8,i32 0,i32 0
%_8 = load ptr, ptr %vec_1
%_6 = call i32 @__array_size(ptr %_8)
%mul_0 = mul i32 %_6, 4
%malloc_0 = add i32 %mul_0, 4
%malloc_ptr_0 = call ptr @__malloc(i32 %malloc_0)
store i32 %_6, ptr %malloc_ptr_0
%array_head_0 = getelementptr i32, ptr %malloc_ptr_0,i32 1
store ptr %array_head_0, ptr %this.data_0
store i32 0, ptr %i_0
br label %for.cond_0

for.cond_0:
%_14 = load ptr, ptr %vec_1
%_12 = call i32 @__array_size(ptr %_14)
%_16 = load i32, ptr %i_0
%slt_0 = icmp slt i32 %_16, %_12
br i1 %slt_0, label %for.body_0, label %for.end_0

for.inc_0:
%_20 = load i32, ptr %i_0
%inc_0 = add i32 %_20, 1
store i32 %inc_0, ptr %i_0
br label %for.cond_0

for.body_0:
%this_9 = load ptr, ptr %this.addr_0
%this.data_1 = getelementptr %struct.vector, ptr %this_9,i32 0,i32 0
%_22 = load ptr, ptr %this.data_1
%_24 = load i32, ptr %i_0
%arrayidx_0 = getelementptr i32, ptr %_22,i32 %_24
%_26 = load ptr, ptr %vec_1
%_28 = load i32, ptr %i_0
%arrayidx_1 = getelementptr i32, ptr %_26,i32 %_28
%_30 = load i32, ptr %arrayidx_1
store i32 %_30, ptr %arrayidx_0
br label %for.inc_0

for.end_0:
br label %exit_init_0

exit_init_0:
ret void

}
define dso_local i32 @vector__getDim(ptr %this_1) {

enter_getDim_0:
%ret_getDim_0 = alloca i32
%this.addr_1 = alloca ptr
store ptr %this_1, ptr %this.addr_1
%this_10 = load ptr, ptr %this.addr_1
%this.data_2 = getelementptr %struct.vector, ptr %this_10,i32 0,i32 0
%_34 = load ptr, ptr %this.data_2
%_36 = icmp eq ptr %_34, null
br i1 %_36, label %if.then_1, label %if.end_1

if.then_1:
store i32 0, ptr %ret_getDim_0
br label %exit_getDim_0

if.end_1:
%this_11 = load ptr, ptr %this.addr_1
%this.data_3 = getelementptr %struct.vector, ptr %this_11,i32 0,i32 0
%_41 = load ptr, ptr %this.data_3
%_39 = call i32 @__array_size(ptr %_41)
store i32 %_39, ptr %ret_getDim_0
br label %exit_getDim_0

exit_getDim_0:
%_31 = load i32, ptr %ret_getDim_0
ret i32 %_31

}
define dso_local i32 @vector__dot(ptr %this_2,ptr %rhs_0) {

enter_dot_0:
%result_0 = alloca i32
%i_1 = alloca i32
%ret_dot_0 = alloca i32
%rhs_3 = alloca ptr
%this.addr_2 = alloca ptr
store ptr %this_2, ptr %this.addr_2
store ptr %rhs_0, ptr %rhs_3
store i32 0, ptr %i_1
store i32 0, ptr %result_0
br label %while.cond_0

while.cond_0:
%this_12 = load ptr, ptr %this.addr_2
%_46 = call i32 @vector__getDim(ptr %this_12)
%_48 = load i32, ptr %i_1
%slt_1 = icmp slt i32 %_48, %_46
br i1 %slt_1, label %while.body_0, label %while.end_0

while.body_0:
%this_13 = load ptr, ptr %this.addr_2
%this.data_4 = getelementptr %struct.vector, ptr %this_13,i32 0,i32 0
%_52 = load ptr, ptr %this.data_4
%_54 = load i32, ptr %i_1
%arrayidx_2 = getelementptr i32, ptr %_52,i32 %_54
%_57 = load ptr, ptr %rhs_3
%_55 = getelementptr %struct.vector, ptr %_57,i32 0,i32 0
%_59 = load ptr, ptr %_55
%_61 = load i32, ptr %i_1
%arrayidx_3 = getelementptr i32, ptr %_59,i32 %_61
%_63 = load i32, ptr %arrayidx_2
%_65 = load i32, ptr %arrayidx_3
%mul_1 = mul i32 %_63, %_65
store i32 %mul_1, ptr %result_0
%_68 = load i32, ptr %i_1
%inc_1 = add i32 %_68, 1
store i32 %inc_1, ptr %i_1
br label %while.cond_0

while.end_0:
%_70 = load i32, ptr %result_0
store i32 %_70, ptr %ret_dot_0
br label %exit_dot_0

exit_dot_0:
%_43 = load i32, ptr %ret_dot_0
ret i32 %_43

}
define dso_local ptr @vector__scalarInPlaceMultiply(ptr %this_3,i32 %c_0) {

enter_scalarInPlaceMultiply_0:
%i_2 = alloca i32
%ret_scalarInPlaceMultiply_0 = alloca ptr
%c_1 = alloca i32
%this.addr_3 = alloca ptr
store ptr %this_3, ptr %this.addr_3
store i32 %c_0, ptr %c_1
%this_14 = load ptr, ptr %this.addr_3
%this.data_5 = getelementptr %struct.vector, ptr %this_14,i32 0,i32 0
%_74 = load ptr, ptr %this.data_5
%_76 = icmp eq ptr %_74, null
br i1 %_76, label %if.then_2, label %if.end_2

if.then_2:
store ptr null, ptr %ret_scalarInPlaceMultiply_0
br label %exit_scalarInPlaceMultiply_0

if.end_2:
store i32 0, ptr %i_2
br label %for.cond_1

for.cond_1:
%this_15 = load ptr, ptr %this.addr_3
%_80 = call i32 @vector__getDim(ptr %this_15)
%_82 = load i32, ptr %i_2
%slt_2 = icmp slt i32 %_82, %_80
br i1 %slt_2, label %for.body_1, label %for.end_1

for.inc_1:
%_86 = load i32, ptr %i_2
%inc_2 = add i32 %_86, 1
store i32 %inc_2, ptr %i_2
br label %for.cond_1

for.body_1:
%_89 = load ptr, ptr %this.addr_3
%_87 = getelementptr %struct.vector, ptr %_89,i32 0,i32 0
%_91 = load ptr, ptr %_87
%_93 = load i32, ptr %i_2
%arrayidx_4 = getelementptr i32, ptr %_91,i32 %_93
%_96 = load ptr, ptr %this.addr_3
%_94 = getelementptr %struct.vector, ptr %_96,i32 0,i32 0
%_98 = load ptr, ptr %_94
%_100 = load i32, ptr %i_2
%arrayidx_5 = getelementptr i32, ptr %_98,i32 %_100
%_102 = load i32, ptr %c_1
%_104 = load i32, ptr %arrayidx_5
%mul_2 = mul i32 %_102, %_104
store i32 %mul_2, ptr %arrayidx_4
br label %for.inc_1

for.end_1:
%_107 = load ptr, ptr %this.addr_3
store ptr %_107, ptr %ret_scalarInPlaceMultiply_0
br label %exit_scalarInPlaceMultiply_0

exit_scalarInPlaceMultiply_0:
%_71 = load ptr, ptr %ret_scalarInPlaceMultiply_0
ret ptr %_71

}
define dso_local ptr @vector__add(ptr %this_4,ptr %rhs_1) {

enter_add_0:
%i_3 = alloca i32
%temp_0 = alloca ptr
%short_cond_0 = alloca i8
%ret_add_0 = alloca ptr
%rhs_4 = alloca ptr
%this.addr_4 = alloca ptr
store ptr %this_4, ptr %this.addr_4
store ptr %rhs_1, ptr %rhs_4
%this_16 = load ptr, ptr %this.addr_4
%_109 = call i32 @vector__getDim(ptr %this_16)
%_112 = load ptr, ptr %rhs_4
%_110 = call i32 @vector__getDim(ptr %_112)
%_116 = icmp ne i32 %_109, %_110
br i1 %_116, label %short.quick_0, label %short.rhs_0

short.quick_0:
store i8 1, ptr %short_cond_0
br label %short.end_0

short.rhs_0:
%this_17 = load ptr, ptr %this.addr_4
%_119 = call i32 @vector__getDim(ptr %this_17)
%_123 = icmp eq i32 %_119, 0
%frombool_0 = zext i1 %_123 to i8
store i8 %frombool_0, ptr %short_cond_0
br label %short.end_0

short.end_0:
%_126 = load i8, ptr %short_cond_0
%_128 = trunc i8 %_126 to i1
br i1 %_128, label %if.then_3, label %if.end_3

if.then_3:
store ptr null, ptr %ret_add_0
br label %exit_add_0

if.end_3:
%malloc_dest_0 = call ptr @__malloc(i32 4)
store ptr %malloc_dest_0, ptr %temp_0
%_132 = load ptr, ptr %temp_0
%_130 = getelementptr %struct.vector, ptr %_132,i32 0,i32 0
%this_18 = load ptr, ptr %this.addr_4
%_133 = call i32 @vector__getDim(ptr %this_18)
%mul_3 = mul i32 %_133, 4
%malloc_1 = add i32 %mul_3, 4
%malloc_ptr_1 = call ptr @__malloc(i32 %malloc_1)
store i32 %_133, ptr %malloc_ptr_1
%array_head_1 = getelementptr i32, ptr %malloc_ptr_1,i32 1
store ptr %array_head_1, ptr %_130
store i32 0, ptr %i_3
br label %for.cond_2

for.cond_2:
%this_19 = load ptr, ptr %this.addr_4
%_137 = call i32 @vector__getDim(ptr %this_19)
%_139 = load i32, ptr %i_3
%slt_3 = icmp slt i32 %_139, %_137
br i1 %slt_3, label %for.body_2, label %for.end_2

for.inc_2:
%_143 = load i32, ptr %i_3
%inc_3 = add i32 %_143, 1
store i32 %inc_3, ptr %i_3
br label %for.cond_2

for.body_2:
%_146 = load ptr, ptr %temp_0
%_144 = getelementptr %struct.vector, ptr %_146,i32 0,i32 0
%_148 = load ptr, ptr %_144
%_150 = load i32, ptr %i_3
%arrayidx_6 = getelementptr i32, ptr %_148,i32 %_150
%this_20 = load ptr, ptr %this.addr_4
%this.data_6 = getelementptr %struct.vector, ptr %this_20,i32 0,i32 0
%_152 = load ptr, ptr %this.data_6
%_154 = load i32, ptr %i_3
%arrayidx_7 = getelementptr i32, ptr %_152,i32 %_154
%_157 = load ptr, ptr %rhs_4
%_155 = getelementptr %struct.vector, ptr %_157,i32 0,i32 0
%_159 = load ptr, ptr %_155
%_161 = load i32, ptr %i_3
%arrayidx_8 = getelementptr i32, ptr %_159,i32 %_161
%_163 = load i32, ptr %arrayidx_7
%_165 = load i32, ptr %arrayidx_8
%add_0 = add i32 %_163, %_165
store i32 %add_0, ptr %arrayidx_6
br label %for.inc_2

for.end_2:
%_168 = load ptr, ptr %temp_0
store ptr %_168, ptr %ret_add_0
br label %exit_add_0

exit_add_0:
%_108 = load ptr, ptr %ret_add_0
ret ptr %_108

}
define dso_local i8 @vector__set(ptr %this_5,i32 %idx_0,i32 %value_0) {

enter_set_0:
%ret_set_0 = alloca i8
%value_1 = alloca i32
%idx_1 = alloca i32
%this.addr_5 = alloca ptr
store ptr %this_5, ptr %this.addr_5
store i32 %idx_0, ptr %idx_1
store i32 %value_0, ptr %value_1
%this_21 = load ptr, ptr %this.addr_5
%_170 = call i32 @vector__getDim(ptr %this_21)
%_173 = load i32, ptr %idx_1
%slt_4 = icmp slt i32 %_170, %_173
br i1 %slt_4, label %if.then_4, label %if.end_4

if.then_4:
%frombool_1 = zext i1 false to i8
store i8 %frombool_1, ptr %ret_set_0
br label %exit_set_0

if.end_4:
%this_22 = load ptr, ptr %this.addr_5
%this.data_7 = getelementptr %struct.vector, ptr %this_22,i32 0,i32 0
%_178 = load ptr, ptr %this.data_7
%_180 = load i32, ptr %idx_1
%arrayidx_9 = getelementptr i32, ptr %_178,i32 %_180
%_182 = load i32, ptr %value_1
store i32 %_182, ptr %arrayidx_9
%frombool_2 = zext i1 true to i8
store i8 %frombool_2, ptr %ret_set_0
br label %exit_set_0

exit_set_0:
%_169 = load i8, ptr %ret_set_0
ret i8 %_169

}
define dso_local ptr @vector__tostring(ptr %this_6) {

enter_tostring_0:
%i_4 = alloca i32
%temp_1 = alloca ptr
%ret_tostring_0 = alloca ptr
%this.addr_6 = alloca ptr
store ptr %this_6, ptr %this.addr_6
store ptr @str.0, ptr %temp_1
%this_23 = load ptr, ptr %this.addr_6
%_187 = call i32 @vector__getDim(ptr %this_23)
%sgt_0 = icmp sgt i32 %_187, 0
br i1 %sgt_0, label %if.then_5, label %if.end_5

if.then_5:
%this_24 = load ptr, ptr %this.addr_6
%this.data_8 = getelementptr %struct.vector, ptr %this_24,i32 0,i32 0
%_192 = load ptr, ptr %this.data_8
%arrayidx_10 = getelementptr i32, ptr %_192,i32 0
%_195 = load i32, ptr %arrayidx_10
%_190 = call ptr @toString(i32 %_195)
%_199 = load ptr, ptr %temp_1
%_197 = call ptr @__str_add(ptr %_199, ptr %_190)
store ptr %_197, ptr %temp_1
br label %if.end_5

if.end_5:
store i32 1, ptr %i_4
br label %for.cond_3

for.cond_3:
%this_25 = load ptr, ptr %this.addr_6
%_204 = call i32 @vector__getDim(ptr %this_25)
%_206 = load i32, ptr %i_4
%slt_5 = icmp slt i32 %_206, %_204
br i1 %slt_5, label %for.body_3, label %for.end_3

for.inc_3:
%_210 = load i32, ptr %i_4
%inc_4 = add i32 %_210, 1
store i32 %inc_4, ptr %i_4
br label %for.cond_3

for.body_3:
%_214 = load ptr, ptr %temp_1
%_212 = call ptr @__str_add(ptr %_214, ptr @str.1)
%this_26 = load ptr, ptr %this.addr_6
%this.data_9 = getelementptr %struct.vector, ptr %this_26,i32 0,i32 0
%_218 = load ptr, ptr %this.data_9
%_220 = load i32, ptr %i_4
%arrayidx_11 = getelementptr i32, ptr %_218,i32 %_220
%_222 = load i32, ptr %arrayidx_11
%_216 = call ptr @toString(i32 %_222)
%_224 = call ptr @__str_add(ptr %_212, ptr %_216)
store ptr %_224, ptr %temp_1
br label %for.inc_3

for.end_3:
%_231 = load ptr, ptr %temp_1
%_229 = call ptr @__str_add(ptr %_231, ptr @str.2)
store ptr %_229, ptr %temp_1
%_235 = load ptr, ptr %temp_1
store ptr %_235, ptr %ret_tostring_0
br label %exit_tostring_0

exit_tostring_0:
%_185 = load ptr, ptr %ret_tostring_0
ret ptr %_185

}
define dso_local i8 @vector__copy(ptr %this_7,ptr %rhs_2) {

enter_copy_0:
%i_5 = alloca i32
%ret_copy_0 = alloca i8
%rhs_5 = alloca ptr
%this.addr_7 = alloca ptr
store ptr %this_7, ptr %this.addr_7
store ptr %rhs_2, ptr %rhs_5
%_239 = load ptr, ptr %rhs_5
%_241 = icmp eq ptr %_239, null
br i1 %_241, label %if.then_6, label %if.end_6

if.then_6:
%frombool_3 = zext i1 false to i8
store i8 %frombool_3, ptr %ret_copy_0
br label %exit_copy_0

if.end_6:
%_247 = load ptr, ptr %rhs_5
%_245 = call i32 @vector__getDim(ptr %_247)
%_251 = icmp eq i32 %_245, 0
br i1 %_251, label %if.then_7, label %if.else_7

if.then_7:
%this_27 = load ptr, ptr %this.addr_7
%this.data_10 = getelementptr %struct.vector, ptr %this_27,i32 0,i32 0
store ptr null, ptr %this.data_10
br label %if.end_7

if.else_7:
%this_28 = load ptr, ptr %this.addr_7
%this.data_11 = getelementptr %struct.vector, ptr %this_28,i32 0,i32 0
%_255 = load ptr, ptr %rhs_5
%_253 = call i32 @vector__getDim(ptr %_255)
%mul_4 = mul i32 %_253, 4
%malloc_2 = add i32 %mul_4, 4
%malloc_ptr_2 = call ptr @__malloc(i32 %malloc_2)
store i32 %_253, ptr %malloc_ptr_2
%array_head_2 = getelementptr i32, ptr %malloc_ptr_2,i32 1
store ptr %array_head_2, ptr %this.data_11
store i32 0, ptr %i_5
br label %for.cond_4

for.cond_4:
%this_29 = load ptr, ptr %this.addr_7
%_259 = call i32 @vector__getDim(ptr %this_29)
%_261 = load i32, ptr %i_5
%slt_6 = icmp slt i32 %_261, %_259
br i1 %slt_6, label %for.body_4, label %for.end_4

for.inc_4:
%_265 = load i32, ptr %i_5
%inc_5 = add i32 %_265, 1
store i32 %inc_5, ptr %i_5
br label %for.cond_4

for.body_4:
%this_30 = load ptr, ptr %this.addr_7
%this.data_12 = getelementptr %struct.vector, ptr %this_30,i32 0,i32 0
%_267 = load ptr, ptr %this.data_12
%_269 = load i32, ptr %i_5
%arrayidx_12 = getelementptr i32, ptr %_267,i32 %_269
%_272 = load ptr, ptr %rhs_5
%_270 = getelementptr %struct.vector, ptr %_272,i32 0,i32 0
%_274 = load ptr, ptr %_270
%_276 = load i32, ptr %i_5
%arrayidx_13 = getelementptr i32, ptr %_274,i32 %_276
%_278 = load i32, ptr %arrayidx_13
store i32 %_278, ptr %arrayidx_12
br label %for.inc_4

for.end_4:
br label %if.end_7

if.end_7:
%frombool_4 = zext i1 true to i8
store i8 %frombool_4, ptr %ret_copy_0
br label %exit_copy_0

exit_copy_0:
%_236 = load i8, ptr %ret_copy_0
ret i8 %_236

}
define dso_local i32 @main() {

enter_main_0:
call void @__cxx_global_var_init()
%y_0 = alloca ptr
%i_6 = alloca i32
%a_0 = alloca ptr
%x_0 = alloca ptr
%ret_main_0 = alloca i32
%malloc_dest_1 = call ptr @__malloc(i32 4)
store ptr %malloc_dest_1, ptr %x_0
%mul_5 = mul i32 10, 4
%malloc_3 = add i32 %mul_5, 4
%malloc_ptr_3 = call ptr @__malloc(i32 %malloc_3)
store i32 10, ptr %malloc_ptr_3
%array_head_3 = getelementptr i32, ptr %malloc_ptr_3,i32 1
store ptr %array_head_3, ptr %a_0
store i32 0, ptr %i_6
br label %for.cond_5

for.cond_5:
%_288 = load i32, ptr %i_6
%slt_7 = icmp slt i32 %_288, 10
br i1 %slt_7, label %for.body_5, label %for.end_5

for.inc_5:
%_292 = load i32, ptr %i_6
%inc_6 = add i32 %_292, 1
store i32 %inc_6, ptr %i_6
br label %for.cond_5

for.body_5:
%_294 = load ptr, ptr %a_0
%_296 = load i32, ptr %i_6
%arrayidx_14 = getelementptr i32, ptr %_294,i32 %_296
%_299 = load i32, ptr %i_6
%sub_0 = sub i32 9, %_299
store i32 %sub_0, ptr %arrayidx_14
br label %for.inc_5

for.end_5:
%_303 = load ptr, ptr %x_0
%_305 = load ptr, ptr %a_0
call void @vector__init(ptr %_303, ptr %_305)
call void @print(ptr @str.3)
%_311 = load ptr, ptr %x_0
%_309 = call ptr @vector__tostring(ptr %_311)
call void @println(ptr %_309)
%malloc_dest_2 = call ptr @__malloc(i32 4)
store ptr %malloc_dest_2, ptr %y_0
%_316 = load ptr, ptr %y_0
%_318 = load ptr, ptr %x_0
%_314 = call i8 @vector__copy(ptr %_316, ptr %_318)
%_321 = load ptr, ptr %y_0
%_319 = call i8 @vector__set(ptr %_321, i32 3, i32 817)
%_326 = trunc i8 %_319 to i1
br i1 %_326, label %if.then_8, label %if.end_8

if.then_8:
call void @println(ptr @str.4)
br label %if.end_8

if.end_8:
call void @print(ptr @str.5)
%_332 = load ptr, ptr %y_0
%_330 = call ptr @vector__tostring(ptr %_332)
call void @println(ptr %_330)
call void @print(ptr @str.6)
%_339 = load ptr, ptr %x_0
%_341 = load ptr, ptr %y_0
%_337 = call ptr @vector__add(ptr %_339, ptr %_341)
%_342 = call ptr @vector__tostring(ptr %_337)
call void @println(ptr %_342)
call void @print(ptr @str.7)
%_351 = load ptr, ptr %x_0
%_353 = load ptr, ptr %y_0
%_349 = call i32 @vector__dot(ptr %_351, ptr %_353)
%_348 = call ptr @toString(i32 %_349)
call void @println(ptr %_348)
call void @print(ptr @str.8)
%_361 = load ptr, ptr %y_0
%shl_0 = shl i32 1, 3
%_359 = call ptr @vector__scalarInPlaceMultiply(ptr %_361, i32 %shl_0)
%_365 = call ptr @vector__tostring(ptr %_359)
call void @println(ptr %_365)
store i32 0, ptr %ret_main_0
br label %exit_main_0

exit_main_0:
%_282 = load i32, ptr %ret_main_0
ret i32 %_282

}
define dso_local void @__cxx_global_var_init() {

enter___cxx_global_var_init_0:
br label %exit___cxx_global_var_init_0

exit___cxx_global_var_init_0:
ret void

}

