	.text
	.attribute	4, 16
	.attribute	5, "rv32i2p0_m2p0_a2p0_c2p0"
	.file	"builtin_lxy.c"
	.globl	print
	.p2align	1
	.type	print,@function
print:
	mv	a1, a0
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	tail	printf
.Lfunc_end0:
	.size	print, .Lfunc_end0-print

	.globl	println
	.p2align	1
	.type	println,@function
println:
	mv	a1, a0
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	tail	printf
.Lfunc_end1:
	.size	println, .Lfunc_end1-println

	.globl	printInt
	.p2align	1
	.type	printInt,@function
printInt:
	mv	a1, a0
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	tail	printf
.Lfunc_end2:
	.size	printInt, .Lfunc_end2-printInt

	.globl	printlnInt
	.p2align	1
	.type	printlnInt,@function
printlnInt:
	mv	a1, a0
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	tail	printf
.Lfunc_end3:
	.size	printlnInt, .Lfunc_end3-printlnInt

	.globl	getString
	.p2align	1
	.type	getString,@function
getString:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	li	a0, 256
	call	malloc
	mv	a1, a0
	sw	a1, 8(sp)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	getString, .Lfunc_end4-getString

	.globl	getInt
	.p2align	1
	.type	getInt,@function
getInt:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	getInt, .Lfunc_end5-getInt

	.globl	toString
	.p2align	1
	.type	toString,@function
toString:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	a0, 4(sp)
	li	a0, 12
	call	malloc
	lw	a2, 4(sp)
	sw	a0, 8(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	call	sprintf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	toString, .Lfunc_end6-toString

	.globl	__malloc
	.p2align	1
	.type	__malloc,@function
__malloc:
	tail	malloc
.Lfunc_end7:
	.size	__malloc, .Lfunc_end7-__malloc

	.globl	__str_add
	.p2align	1
	.type	__str_add,@function
__str_add:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	a1, 20(sp)
	sw	a0, 16(sp)
	call	strlen
	mv	a1, a0
	lw	a0, 20(sp)
	sw	a1, 12(sp)
	call	strlen
	mv	a1, a0
	lw	a0, 12(sp)
	add	a0, a0, a1
	addi	a0, a0, 1
	call	malloc
	lw	a1, 16(sp)
	sw	a0, 24(sp)
	call	strcpy
	lw	a1, 20(sp)
	lw	a0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	tail	strcat
.Lfunc_end8:
	.size	__str_add, .Lfunc_end8-__str_add

	.globl	__str_eq
	.p2align	1
	.type	__str_eq,@function
__str_eq:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	__str_eq, .Lfunc_end9-__str_eq

	.globl	__str_ne
	.p2align	1
	.type	__str_ne,@function
__str_ne:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end10:
	.size	__str_ne, .Lfunc_end10-__str_ne

	.globl	__str_lt
	.p2align	1
	.type	__str_lt,@function
__str_lt:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end11:
	.size	__str_lt, .Lfunc_end11-__str_lt

	.globl	__str_le
	.p2align	1
	.type	__str_le,@function
__str_le:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	__str_le, .Lfunc_end12-__str_le

	.globl	__str_gt
	.p2align	1
	.type	__str_gt,@function
__str_gt:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	mv	a1, a0
	li	a0, 0
	slt	a0, a0, a1
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	__str_gt, .Lfunc_end13-__str_gt

	.globl	__str_ge
	.p2align	1
	.type	__str_ge,@function
__str_ge:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	__str_ge, .Lfunc_end14-__str_ge

	.globl	__str_length
	.p2align	1
	.type	__str_length,@function
__str_length:
	tail	strlen
.Lfunc_end15:
	.size	__str_length, .Lfunc_end15-__str_length

	.globl	__str_substring
	.p2align	1
	.type	__str_substring,@function
__str_substring:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	a1, 12(sp)
	sw	a0, 16(sp)
	sub	a0, a2, a1
	sw	a0, 20(sp)
	addi	a0, a0, 1
	call	malloc
	lw	a3, 12(sp)
	lw	a1, 16(sp)
	lw	a2, 20(sp)
	sw	a0, 24(sp)
	add	a1, a1, a3
	call	memcpy
	lw	a1, 20(sp)
	lw	a0, 24(sp)
	add	a2, a0, a1
	li	a1, 0
	sb	a1, 0(a2)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end16:
	.size	__str_substring, .Lfunc_end16-__str_substring

	.globl	__str_parseInt
	.p2align	1
	.type	__str_parseInt,@function
__str_parseInt:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 8
	call	sscanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	__str_parseInt, .Lfunc_end17-__str_parseInt

	.globl	__str_ord
	.p2align	1
	.type	__str_ord,@function
__str_ord:
	add	a0, a0, a1
	lbu	a0, 0(a0)
	ret
.Lfunc_end18:
	.size	__str_ord, .Lfunc_end18-__str_ord

	.globl	__array.size
	.p2align	1
	.type	__array.size,@function
__array.size:
	lw	a0, -4(a0)
	ret
.Lfunc_end19:
	.size	__array.size, .Lfunc_end19-__array.size

	.type	.L.str,@object
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"Ubuntu clang version 15.0.7"
	.section	".note.GNU-stack","",@progbits
	.addrsig
