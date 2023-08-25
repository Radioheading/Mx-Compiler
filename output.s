	.section .data
@N:
	.word 	0
@head:
	.word 	0
@startx:
	.word 	0
@starty:
	.word 	0
@targetx:
	.word 	0
@targety:
	.word 	0
@x:
	.word 	0
@y:
	.word 	0
@xlist:
	.word 	0
@ylist:
	.word 	0
@tail:
	.word 	0
@ok:
	.word 	0
@now:
	.word 	0
@dx:
	.word 	0
@dy:
	.word 	0
@step:
	.word 	0
@i:
	.word 	0
@j:
	.word 	0
	.section .rodata
.str.0:
.asciz	"no solution!\n"
	.text
	.globl	origin
origin:
.Lenter_origin_0:
	addi	sp, sp, -272
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 8(sp)
	lw	t2, 8(sp)
	add	t0, sp, t2
	sw	t0, 12(sp)
	lw	t1, 12(sp)
	sw	a0, 0(t1)
	li	t0, 0
	sw	t0, 16(sp)
	la	t0, @head
	sw	t0, 20(sp)
	lw	t1, 20(sp)
	lw	t0, 16(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 24(sp)
	la	t0, @tail
	sw	t0, 28(sp)
	lw	t1, 28(sp)
	lw	t0, 24(sp)
	sw	t0, 0(t1)
	lw	t1, 12(sp)
	lw	t0, 0(t1)
	sw	t0, 32(sp)
	li	t0, 4
	sw	t0, 36(sp)
	lw	t1, 32(sp)
	lw	t2, 36(sp)
	mul	t0, t1, t2
	sw	t0, 40(sp)
	li	t0, 4
	sw	t0, 44(sp)
	lw	t1, 40(sp)
	lw	t2, 44(sp)
	add	t0, t1, t2
	sw	t0, 48(sp)
	lw	t1, 48(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 52(sp)
	lw	t1, 52(sp)
	lw	t0, 32(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 56(sp)
	lw	t1, 56(sp)
	slli	t0, t1, 2
	sw	t0, 60(sp)
	lw	t1, 52(sp)
	lw	t2, 60(sp)
	add	t0, t1, t2
	sw	t0, 64(sp)
	la	t0, @step
	sw	t0, 68(sp)
	lw	t1, 68(sp)
	lw	t0, 64(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 72(sp)
	la	t0, @i
	sw	t0, 76(sp)
	lw	t1, 76(sp)
	lw	t0, 72(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_0

.Lfor.cond_0:
	la	t0, @i
	sw	t0, 80(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 84(sp)
	lw	t1, 12(sp)
	lw	t0, 0(t1)
	sw	t0, 88(sp)
	lw	t1, 84(sp)
	lw	t2, 88(sp)
	slt	t0, t1, t2
	sb	t0, 92(sp)
	lb	t1, 92(sp)
	beqz	t1, .Lfor.end_0
	j	.Lfor.body_0

.Lfor.inc_0:
	la	t0, @i
	sw	t0, 93(sp)
	lw	t1, 93(sp)
	lw	t0, 0(t1)
	sw	t0, 97(sp)
	li	t0, 1
	sw	t0, 101(sp)
	lw	t1, 97(sp)
	lw	t2, 101(sp)
	add	t0, t1, t2
	sw	t0, 105(sp)
	la	t0, @i
	sw	t0, 109(sp)
	lw	t1, 109(sp)
	lw	t0, 105(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_0

.Lfor.body_0:
	la	t0, @step
	sw	t0, 113(sp)
	lw	t1, 113(sp)
	lw	t0, 0(t1)
	sw	t0, 117(sp)
	la	t0, @i
	sw	t0, 121(sp)
	lw	t1, 121(sp)
	lw	t0, 0(t1)
	sw	t0, 125(sp)
	lw	t1, 125(sp)
	slli	t0, t1, 2
	sw	t0, 129(sp)
	lw	t1, 117(sp)
	lw	t2, 129(sp)
	add	t0, t1, t2
	sw	t0, 133(sp)
	lw	t1, 12(sp)
	lw	t0, 0(t1)
	sw	t0, 137(sp)
	li	t0, 4
	sw	t0, 141(sp)
	lw	t1, 137(sp)
	lw	t2, 141(sp)
	mul	t0, t1, t2
	sw	t0, 145(sp)
	li	t0, 4
	sw	t0, 149(sp)
	lw	t1, 145(sp)
	lw	t2, 149(sp)
	add	t0, t1, t2
	sw	t0, 153(sp)
	lw	t1, 153(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 157(sp)
	lw	t1, 157(sp)
	lw	t0, 137(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 161(sp)
	lw	t1, 161(sp)
	slli	t0, t1, 2
	sw	t0, 165(sp)
	lw	t1, 157(sp)
	lw	t2, 165(sp)
	add	t0, t1, t2
	sw	t0, 169(sp)
	lw	t1, 133(sp)
	lw	t0, 169(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 173(sp)
	la	t0, @j
	sw	t0, 177(sp)
	lw	t1, 177(sp)
	lw	t0, 173(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_1

.Lfor.cond_1:
	la	t0, @j
	sw	t0, 181(sp)
	lw	t1, 181(sp)
	lw	t0, 0(t1)
	sw	t0, 185(sp)
	lw	t1, 12(sp)
	lw	t0, 0(t1)
	sw	t0, 189(sp)
	lw	t1, 185(sp)
	lw	t2, 189(sp)
	slt	t0, t1, t2
	sb	t0, 193(sp)
	lb	t1, 193(sp)
	beqz	t1, .Lfor.end_1
	j	.Lfor.body_1

.Lfor.inc_1:
	la	t0, @j
	sw	t0, 194(sp)
	lw	t1, 194(sp)
	lw	t0, 0(t1)
	sw	t0, 198(sp)
	li	t0, 1
	sw	t0, 202(sp)
	lw	t1, 198(sp)
	lw	t2, 202(sp)
	add	t0, t1, t2
	sw	t0, 206(sp)
	la	t0, @j
	sw	t0, 210(sp)
	lw	t1, 210(sp)
	lw	t0, 206(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_1

.Lfor.body_1:
	la	t0, @step
	sw	t0, 214(sp)
	lw	t1, 214(sp)
	lw	t0, 0(t1)
	sw	t0, 218(sp)
	la	t0, @i
	sw	t0, 222(sp)
	lw	t1, 222(sp)
	lw	t0, 0(t1)
	sw	t0, 226(sp)
	lw	t1, 226(sp)
	slli	t0, t1, 2
	sw	t0, 230(sp)
	lw	t1, 218(sp)
	lw	t2, 230(sp)
	add	t0, t1, t2
	sw	t0, 234(sp)
	lw	t1, 234(sp)
	lw	t0, 0(t1)
	sw	t0, 238(sp)
	la	t0, @j
	sw	t0, 242(sp)
	lw	t1, 242(sp)
	lw	t0, 0(t1)
	sw	t0, 246(sp)
	lw	t1, 246(sp)
	slli	t0, t1, 2
	sw	t0, 250(sp)
	lw	t1, 238(sp)
	lw	t2, 250(sp)
	add	t0, t1, t2
	sw	t0, 254(sp)
	li	t0, 0
	sw	t0, 258(sp)
	lw	t1, 254(sp)
	lw	t0, 258(sp)
	sw	t0, 0(t1)
	j	.Lfor.inc_1

.Lfor.end_1:
	j	.Lfor.inc_0

.Lfor.end_0:
	j	.Lexit_origin_0

.Lexit_origin_0:
	lw	ra, 0(sp)
	addi	sp, sp, 272
	ret


	.text
	.globl	check
check:
.Lenter_check_0:
	addi	sp, sp, -92
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 16(sp)
	lw	t2, 16(sp)
	add	t0, sp, t2
	sw	t0, 20(sp)
	li	t0, 8
	sw	t0, 24(sp)
	lw	t2, 24(sp)
	add	t0, sp, t2
	sw	t0, 28(sp)
	li	t0, 12
	sw	t0, 32(sp)
	lw	t2, 32(sp)
	add	t0, sp, t2
	sw	t0, 36(sp)
	lw	t1, 36(sp)
	sw	a0, 0(t1)
	lw	t1, 36(sp)
	lw	t0, 0(t1)
	sw	t0, 40(sp)
	la	t0, @N
	sw	t0, 44(sp)
	lw	t1, 44(sp)
	lw	t0, 0(t1)
	sw	t0, 48(sp)
	lw	t1, 40(sp)
	lw	t2, 48(sp)
	slt	t0, t1, t2
	sb	t0, 52(sp)
	lb	t1, 52(sp)
	beqz	t1, .Lshort.quick_0
	j	.Lshort.rhs_0

.Lshort.rhs_0:
	lw	t1, 36(sp)
	lw	t0, 0(t1)
	sw	t0, 53(sp)
	li	t0, 0
	sw	t0, 57(sp)
	lw	t1, 53(sp)
	lw	t2, 57(sp)
	slt	t0, t1, t2
	sw	t0, 61(sp)
	lw	t1, 61(sp)
	xori	t0, t1, 1
	sb	t0, 65(sp)
	lb	t1, 65(sp)
	mv	t0, t1
	sb	t0, 66(sp)
	lw	t1, 20(sp)
	lb	t0, 66(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_0

.Lshort.quick_0:
	li	t0, 0
	sb	t0, 67(sp)
	lw	t1, 20(sp)
	lb	t0, 67(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_0

.Lshort.end_0:
	lw	t1, 20(sp)
	lb	t0, 0(t1)
	sb	t0, 68(sp)
	lw	t1, 28(sp)
	lb	t0, 68(sp)
	sb	t0, 0(t1)
	j	.Lexit_check_0

.Lexit_check_0:
	lw	t1, 28(sp)
	lb	t0, 0(t1)
	sb	t0, 69(sp)
	lb	t1, 69(sp)
	mv	a0, t1
	lw	ra, 0(sp)
	addi	sp, sp, 92
	ret


	.text
	.globl	addList
addList:
.Lenter_addList_0:
	addi	sp, sp, -372
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 24(sp)
	lw	t2, 24(sp)
	add	t0, sp, t2
	sw	t0, 28(sp)
	li	t0, 8
	sw	t0, 32(sp)
	lw	t2, 32(sp)
	add	t0, sp, t2
	sw	t0, 36(sp)
	li	t0, 12
	sw	t0, 40(sp)
	lw	t2, 40(sp)
	add	t0, sp, t2
	sw	t0, 44(sp)
	li	t0, 16
	sw	t0, 48(sp)
	lw	t2, 48(sp)
	add	t0, sp, t2
	sw	t0, 52(sp)
	li	t0, 20
	sw	t0, 56(sp)
	lw	t2, 56(sp)
	add	t0, sp, t2
	sw	t0, 60(sp)
	lw	t1, 60(sp)
	sw	a0, 0(t1)
	lw	t1, 52(sp)
	sw	a1, 0(t1)
	lw	t1, 60(sp)
	lw	t0, 0(t1)
	sw	t0, 64(sp)
	lw	t1, 64(sp)
	mv	a0, t1
	call	check
	mv	t0, a0
	sb	t0, 68(sp)
	lb	t1, 68(sp)
	mv	t0, t1
	sb	t0, 69(sp)
	lb	t1, 69(sp)
	beqz	t1, .Lshort.quick_1
	j	.Lshort.rhs_1

.Lshort.rhs_1:
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 70(sp)
	lw	t1, 70(sp)
	mv	a0, t1
	call	check
	mv	t0, a0
	sb	t0, 74(sp)
	lw	t1, 44(sp)
	lb	t0, 74(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_1

.Lshort.quick_1:
	li	t0, 0
	sb	t0, 75(sp)
	lw	t1, 44(sp)
	lb	t0, 75(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_1

.Lshort.end_1:
	lw	t1, 44(sp)
	lb	t0, 0(t1)
	sb	t0, 76(sp)
	lb	t1, 76(sp)
	mv	t0, t1
	sb	t0, 77(sp)
	lb	t1, 77(sp)
	beqz	t1, .Lshort.quick_2
	j	.Lshort.rhs_2

.Lshort.rhs_2:
	la	t0, @step
	sw	t0, 78(sp)
	lw	t1, 78(sp)
	lw	t0, 0(t1)
	sw	t0, 82(sp)
	lw	t1, 60(sp)
	lw	t0, 0(t1)
	sw	t0, 86(sp)
	lw	t1, 86(sp)
	slli	t0, t1, 2
	sw	t0, 90(sp)
	lw	t1, 82(sp)
	lw	t2, 90(sp)
	add	t0, t1, t2
	sw	t0, 94(sp)
	lw	t1, 94(sp)
	lw	t0, 0(t1)
	sw	t0, 98(sp)
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 102(sp)
	lw	t1, 102(sp)
	slli	t0, t1, 2
	sw	t0, 106(sp)
	lw	t1, 98(sp)
	lw	t2, 106(sp)
	add	t0, t1, t2
	sw	t0, 110(sp)
	li	t0, 0
	sw	t0, 114(sp)
	li	t0, 1
	sw	t0, 118(sp)
	lw	t1, 114(sp)
	lw	t2, 118(sp)
	sub	t0, t1, t2
	sw	t0, 122(sp)
	lw	t1, 110(sp)
	lw	t0, 0(t1)
	sw	t0, 126(sp)
	lw	t1, 126(sp)
	lw	t2, 122(sp)
	sub	t0, t1, t2
	sw	t0, 130(sp)
	lw	t1, 130(sp)
	seqz	t0, t1
	sb	t0, 134(sp)
	lb	t1, 134(sp)
	mv	t0, t1
	sb	t0, 135(sp)
	lw	t1, 36(sp)
	lb	t0, 135(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_2

.Lshort.quick_2:
	li	t0, 0
	sb	t0, 136(sp)
	lw	t1, 36(sp)
	lb	t0, 136(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_2

.Lshort.end_2:
	lw	t1, 36(sp)
	lb	t0, 0(t1)
	sb	t0, 137(sp)
	lb	t1, 137(sp)
	mv	t0, t1
	sb	t0, 138(sp)
	lb	t1, 138(sp)
	beqz	t1, .Lif.end_0
	j	.Lif.then_0

.Lif.then_0:
	la	t0, @tail
	sw	t0, 139(sp)
	lw	t1, 139(sp)
	lw	t0, 0(t1)
	sw	t0, 143(sp)
	li	t0, 1
	sw	t0, 147(sp)
	lw	t1, 143(sp)
	lw	t2, 147(sp)
	add	t0, t1, t2
	sw	t0, 151(sp)
	la	t0, @tail
	sw	t0, 155(sp)
	lw	t1, 155(sp)
	lw	t0, 151(sp)
	sw	t0, 0(t1)
	la	t0, @xlist
	sw	t0, 159(sp)
	lw	t1, 159(sp)
	lw	t0, 0(t1)
	sw	t0, 163(sp)
	la	t0, @tail
	sw	t0, 167(sp)
	lw	t1, 167(sp)
	lw	t0, 0(t1)
	sw	t0, 171(sp)
	lw	t1, 171(sp)
	slli	t0, t1, 2
	sw	t0, 175(sp)
	lw	t1, 163(sp)
	lw	t2, 175(sp)
	add	t0, t1, t2
	sw	t0, 179(sp)
	lw	t1, 60(sp)
	lw	t0, 0(t1)
	sw	t0, 183(sp)
	lw	t1, 179(sp)
	lw	t0, 183(sp)
	sw	t0, 0(t1)
	la	t0, @ylist
	sw	t0, 187(sp)
	lw	t1, 187(sp)
	lw	t0, 0(t1)
	sw	t0, 191(sp)
	la	t0, @tail
	sw	t0, 195(sp)
	lw	t1, 195(sp)
	lw	t0, 0(t1)
	sw	t0, 199(sp)
	lw	t1, 199(sp)
	slli	t0, t1, 2
	sw	t0, 203(sp)
	lw	t1, 191(sp)
	lw	t2, 203(sp)
	add	t0, t1, t2
	sw	t0, 207(sp)
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 211(sp)
	lw	t1, 207(sp)
	lw	t0, 211(sp)
	sw	t0, 0(t1)
	la	t0, @step
	sw	t0, 215(sp)
	lw	t1, 215(sp)
	lw	t0, 0(t1)
	sw	t0, 219(sp)
	lw	t1, 60(sp)
	lw	t0, 0(t1)
	sw	t0, 223(sp)
	lw	t1, 223(sp)
	slli	t0, t1, 2
	sw	t0, 227(sp)
	lw	t1, 219(sp)
	lw	t2, 227(sp)
	add	t0, t1, t2
	sw	t0, 231(sp)
	lw	t1, 231(sp)
	lw	t0, 0(t1)
	sw	t0, 235(sp)
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 239(sp)
	lw	t1, 239(sp)
	slli	t0, t1, 2
	sw	t0, 243(sp)
	lw	t1, 235(sp)
	lw	t2, 243(sp)
	add	t0, t1, t2
	sw	t0, 247(sp)
	la	t0, @now
	sw	t0, 251(sp)
	lw	t1, 251(sp)
	lw	t0, 0(t1)
	sw	t0, 255(sp)
	li	t0, 1
	sw	t0, 259(sp)
	lw	t1, 255(sp)
	lw	t2, 259(sp)
	add	t0, t1, t2
	sw	t0, 263(sp)
	lw	t1, 247(sp)
	lw	t0, 263(sp)
	sw	t0, 0(t1)
	lw	t1, 60(sp)
	lw	t0, 0(t1)
	sw	t0, 267(sp)
	la	t0, @targetx
	sw	t0, 271(sp)
	lw	t1, 271(sp)
	lw	t0, 0(t1)
	sw	t0, 275(sp)
	lw	t1, 267(sp)
	lw	t2, 275(sp)
	sub	t0, t1, t2
	sw	t0, 279(sp)
	lw	t1, 279(sp)
	seqz	t0, t1
	sb	t0, 283(sp)
	lb	t1, 283(sp)
	beqz	t1, .Lshort.quick_3
	j	.Lshort.rhs_3

.Lshort.rhs_3:
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 284(sp)
	la	t0, @targety
	sw	t0, 288(sp)
	lw	t1, 288(sp)
	lw	t0, 0(t1)
	sw	t0, 292(sp)
	lw	t1, 284(sp)
	lw	t2, 292(sp)
	sub	t0, t1, t2
	sw	t0, 296(sp)
	lw	t1, 296(sp)
	seqz	t0, t1
	sb	t0, 300(sp)
	lb	t1, 300(sp)
	mv	t0, t1
	sb	t0, 301(sp)
	lw	t1, 28(sp)
	lb	t0, 301(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_3

.Lshort.quick_3:
	li	t0, 0
	sb	t0, 302(sp)
	lw	t1, 28(sp)
	lb	t0, 302(sp)
	sb	t0, 0(t1)
	j	.Lshort.end_3

.Lshort.end_3:
	lw	t1, 28(sp)
	lb	t0, 0(t1)
	sb	t0, 303(sp)
	lb	t1, 303(sp)
	mv	t0, t1
	sb	t0, 304(sp)
	lb	t1, 304(sp)
	beqz	t1, .Lif.end_1
	j	.Lif.then_1

.Lif.then_1:
	li	t0, 1
	sw	t0, 305(sp)
	la	t0, @ok
	sw	t0, 309(sp)
	lw	t1, 309(sp)
	lw	t0, 305(sp)
	sw	t0, 0(t1)
	j	.Lif.end_1

.Lif.end_1:
	j	.Lif.end_0

.Lif.end_0:
	j	.Lexit_addList_0

.Lexit_addList_0:
	lw	ra, 0(sp)
	addi	sp, sp, 372
	ret


	.text
	.globl	main
main:
.Lenter_main_0:
	addi	sp, sp, -1068
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 8(sp)
	lw	t2, 8(sp)
	add	t0, sp, t2
	sw	t0, 12(sp)
	li	t0, 0
	sw	t0, 16(sp)
	lw	t1, 12(sp)
	lw	t0, 16(sp)
	sw	t0, 0(t1)
	call	__mx_global_var_init
	li	t0, 106
	sw	t0, 20(sp)
	lw	t1, 20(sp)
	mv	a0, t1
	call	origin
	mv	t0, a0
	sb	t0, 24(sp)
	call	getInt
	mv	t0, a0
	sw	t0, 24(sp)
	la	t0, @N
	sw	t0, 28(sp)
	lw	t1, 28(sp)
	lw	t0, 24(sp)
	sw	t0, 0(t1)
	la	t0, @N
	sw	t0, 32(sp)
	lw	t1, 32(sp)
	lw	t0, 0(t1)
	sw	t0, 36(sp)
	li	t0, 1
	sw	t0, 40(sp)
	lw	t1, 36(sp)
	lw	t2, 40(sp)
	sub	t0, t1, t2
	sw	t0, 44(sp)
	la	t0, @targety
	sw	t0, 48(sp)
	lw	t1, 48(sp)
	lw	t0, 44(sp)
	sw	t0, 0(t1)
	la	t0, @targety
	sw	t0, 52(sp)
	lw	t1, 52(sp)
	lw	t0, 0(t1)
	sw	t0, 56(sp)
	la	t0, @targetx
	sw	t0, 60(sp)
	lw	t1, 60(sp)
	lw	t0, 56(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 64(sp)
	la	t0, @i
	sw	t0, 68(sp)
	lw	t1, 68(sp)
	lw	t0, 64(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_2

.Lfor.cond_2:
	la	t0, @i
	sw	t0, 72(sp)
	lw	t1, 72(sp)
	lw	t0, 0(t1)
	sw	t0, 76(sp)
	la	t0, @N
	sw	t0, 80(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 84(sp)
	lw	t1, 76(sp)
	lw	t2, 84(sp)
	slt	t0, t1, t2
	sb	t0, 88(sp)
	lb	t1, 88(sp)
	beqz	t1, .Lfor.end_2
	j	.Lfor.body_2

.Lfor.inc_2:
	la	t0, @i
	sw	t0, 89(sp)
	lw	t1, 89(sp)
	lw	t0, 0(t1)
	sw	t0, 93(sp)
	li	t0, 1
	sw	t0, 97(sp)
	lw	t1, 93(sp)
	lw	t2, 97(sp)
	add	t0, t1, t2
	sw	t0, 101(sp)
	la	t0, @i
	sw	t0, 105(sp)
	lw	t1, 105(sp)
	lw	t0, 101(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_2

.Lfor.body_2:
	li	t0, 0
	sw	t0, 109(sp)
	la	t0, @j
	sw	t0, 113(sp)
	lw	t1, 113(sp)
	lw	t0, 109(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_3

.Lfor.cond_3:
	la	t0, @j
	sw	t0, 117(sp)
	lw	t1, 117(sp)
	lw	t0, 0(t1)
	sw	t0, 121(sp)
	la	t0, @N
	sw	t0, 125(sp)
	lw	t1, 125(sp)
	lw	t0, 0(t1)
	sw	t0, 129(sp)
	lw	t1, 121(sp)
	lw	t2, 129(sp)
	slt	t0, t1, t2
	sb	t0, 133(sp)
	lb	t1, 133(sp)
	beqz	t1, .Lfor.end_3
	j	.Lfor.body_3

.Lfor.inc_3:
	la	t0, @j
	sw	t0, 134(sp)
	lw	t1, 134(sp)
	lw	t0, 0(t1)
	sw	t0, 138(sp)
	li	t0, 1
	sw	t0, 142(sp)
	lw	t1, 138(sp)
	lw	t2, 142(sp)
	add	t0, t1, t2
	sw	t0, 146(sp)
	la	t0, @j
	sw	t0, 150(sp)
	lw	t1, 150(sp)
	lw	t0, 146(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_3

.Lfor.body_3:
	la	t0, @step
	sw	t0, 154(sp)
	lw	t1, 154(sp)
	lw	t0, 0(t1)
	sw	t0, 158(sp)
	la	t0, @i
	sw	t0, 162(sp)
	lw	t1, 162(sp)
	lw	t0, 0(t1)
	sw	t0, 166(sp)
	lw	t1, 166(sp)
	slli	t0, t1, 2
	sw	t0, 170(sp)
	lw	t1, 158(sp)
	lw	t2, 170(sp)
	add	t0, t1, t2
	sw	t0, 174(sp)
	lw	t1, 174(sp)
	lw	t0, 0(t1)
	sw	t0, 178(sp)
	la	t0, @j
	sw	t0, 182(sp)
	lw	t1, 182(sp)
	lw	t0, 0(t1)
	sw	t0, 186(sp)
	lw	t1, 186(sp)
	slli	t0, t1, 2
	sw	t0, 190(sp)
	lw	t1, 178(sp)
	lw	t2, 190(sp)
	add	t0, t1, t2
	sw	t0, 194(sp)
	li	t0, 0
	sw	t0, 198(sp)
	li	t0, 1
	sw	t0, 202(sp)
	lw	t1, 198(sp)
	lw	t2, 202(sp)
	sub	t0, t1, t2
	sw	t0, 206(sp)
	lw	t1, 194(sp)
	lw	t0, 206(sp)
	sw	t0, 0(t1)
	j	.Lfor.inc_3

.Lfor.end_3:
	j	.Lfor.inc_2

.Lfor.end_2:
	la	t0, @dx
	sw	t0, 210(sp)
	lw	t1, 210(sp)
	lw	t0, 0(t1)
	sw	t0, 214(sp)
	li	t0, 0
	sw	t0, 218(sp)
	lw	t1, 218(sp)
	slli	t0, t1, 2
	sw	t0, 222(sp)
	lw	t1, 214(sp)
	lw	t2, 222(sp)
	add	t0, t1, t2
	sw	t0, 226(sp)
	li	t0, 0
	sw	t0, 230(sp)
	li	t0, 2
	sw	t0, 234(sp)
	lw	t1, 230(sp)
	lw	t2, 234(sp)
	sub	t0, t1, t2
	sw	t0, 238(sp)
	lw	t1, 226(sp)
	lw	t0, 238(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 242(sp)
	lw	t1, 242(sp)
	lw	t0, 0(t1)
	sw	t0, 246(sp)
	li	t0, 0
	sw	t0, 250(sp)
	lw	t1, 250(sp)
	slli	t0, t1, 2
	sw	t0, 254(sp)
	lw	t1, 246(sp)
	lw	t2, 254(sp)
	add	t0, t1, t2
	sw	t0, 258(sp)
	li	t0, 0
	sw	t0, 262(sp)
	li	t0, 1
	sw	t0, 266(sp)
	lw	t1, 262(sp)
	lw	t2, 266(sp)
	sub	t0, t1, t2
	sw	t0, 270(sp)
	lw	t1, 258(sp)
	lw	t0, 270(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 274(sp)
	lw	t1, 274(sp)
	lw	t0, 0(t1)
	sw	t0, 278(sp)
	li	t0, 1
	sw	t0, 282(sp)
	lw	t1, 282(sp)
	slli	t0, t1, 2
	sw	t0, 286(sp)
	lw	t1, 278(sp)
	lw	t2, 286(sp)
	add	t0, t1, t2
	sw	t0, 290(sp)
	li	t0, 0
	sw	t0, 294(sp)
	li	t0, 2
	sw	t0, 298(sp)
	lw	t1, 294(sp)
	lw	t2, 298(sp)
	sub	t0, t1, t2
	sw	t0, 302(sp)
	lw	t1, 290(sp)
	lw	t0, 302(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 306(sp)
	lw	t1, 306(sp)
	lw	t0, 0(t1)
	sw	t0, 310(sp)
	li	t0, 1
	sw	t0, 314(sp)
	lw	t1, 314(sp)
	slli	t0, t1, 2
	sw	t0, 318(sp)
	lw	t1, 310(sp)
	lw	t2, 318(sp)
	add	t0, t1, t2
	sw	t0, 322(sp)
	li	t0, 1
	sw	t0, 326(sp)
	lw	t1, 322(sp)
	lw	t0, 326(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 330(sp)
	lw	t1, 330(sp)
	lw	t0, 0(t1)
	sw	t0, 334(sp)
	li	t0, 2
	sw	t0, 338(sp)
	lw	t1, 338(sp)
	slli	t0, t1, 2
	sw	t0, 342(sp)
	lw	t1, 334(sp)
	lw	t2, 342(sp)
	add	t0, t1, t2
	sw	t0, 346(sp)
	li	t0, 2
	sw	t0, 350(sp)
	lw	t1, 346(sp)
	lw	t0, 350(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 354(sp)
	lw	t1, 354(sp)
	lw	t0, 0(t1)
	sw	t0, 358(sp)
	li	t0, 2
	sw	t0, 362(sp)
	lw	t1, 362(sp)
	slli	t0, t1, 2
	sw	t0, 366(sp)
	lw	t1, 358(sp)
	lw	t2, 366(sp)
	add	t0, t1, t2
	sw	t0, 370(sp)
	li	t0, 0
	sw	t0, 374(sp)
	li	t0, 1
	sw	t0, 378(sp)
	lw	t1, 374(sp)
	lw	t2, 378(sp)
	sub	t0, t1, t2
	sw	t0, 382(sp)
	lw	t1, 370(sp)
	lw	t0, 382(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 386(sp)
	lw	t1, 386(sp)
	lw	t0, 0(t1)
	sw	t0, 390(sp)
	li	t0, 3
	sw	t0, 394(sp)
	lw	t1, 394(sp)
	slli	t0, t1, 2
	sw	t0, 398(sp)
	lw	t1, 390(sp)
	lw	t2, 398(sp)
	add	t0, t1, t2
	sw	t0, 402(sp)
	li	t0, 2
	sw	t0, 406(sp)
	lw	t1, 402(sp)
	lw	t0, 406(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 410(sp)
	lw	t1, 410(sp)
	lw	t0, 0(t1)
	sw	t0, 414(sp)
	li	t0, 3
	sw	t0, 418(sp)
	lw	t1, 418(sp)
	slli	t0, t1, 2
	sw	t0, 422(sp)
	lw	t1, 414(sp)
	lw	t2, 422(sp)
	add	t0, t1, t2
	sw	t0, 426(sp)
	li	t0, 1
	sw	t0, 430(sp)
	lw	t1, 426(sp)
	lw	t0, 430(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 434(sp)
	lw	t1, 434(sp)
	lw	t0, 0(t1)
	sw	t0, 438(sp)
	li	t0, 4
	sw	t0, 442(sp)
	lw	t1, 442(sp)
	slli	t0, t1, 2
	sw	t0, 446(sp)
	lw	t1, 438(sp)
	lw	t2, 446(sp)
	add	t0, t1, t2
	sw	t0, 450(sp)
	li	t0, 0
	sw	t0, 454(sp)
	li	t0, 1
	sw	t0, 458(sp)
	lw	t1, 454(sp)
	lw	t2, 458(sp)
	sub	t0, t1, t2
	sw	t0, 462(sp)
	lw	t1, 450(sp)
	lw	t0, 462(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 466(sp)
	lw	t1, 466(sp)
	lw	t0, 0(t1)
	sw	t0, 470(sp)
	li	t0, 4
	sw	t0, 474(sp)
	lw	t1, 474(sp)
	slli	t0, t1, 2
	sw	t0, 478(sp)
	lw	t1, 470(sp)
	lw	t2, 478(sp)
	add	t0, t1, t2
	sw	t0, 482(sp)
	li	t0, 0
	sw	t0, 486(sp)
	li	t0, 2
	sw	t0, 490(sp)
	lw	t1, 486(sp)
	lw	t2, 490(sp)
	sub	t0, t1, t2
	sw	t0, 494(sp)
	lw	t1, 482(sp)
	lw	t0, 494(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 498(sp)
	lw	t1, 498(sp)
	lw	t0, 0(t1)
	sw	t0, 502(sp)
	li	t0, 5
	sw	t0, 506(sp)
	lw	t1, 506(sp)
	slli	t0, t1, 2
	sw	t0, 510(sp)
	lw	t1, 502(sp)
	lw	t2, 510(sp)
	add	t0, t1, t2
	sw	t0, 514(sp)
	li	t0, 0
	sw	t0, 518(sp)
	li	t0, 1
	sw	t0, 522(sp)
	lw	t1, 518(sp)
	lw	t2, 522(sp)
	sub	t0, t1, t2
	sw	t0, 526(sp)
	lw	t1, 514(sp)
	lw	t0, 526(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 530(sp)
	lw	t1, 530(sp)
	lw	t0, 0(t1)
	sw	t0, 534(sp)
	li	t0, 5
	sw	t0, 538(sp)
	lw	t1, 538(sp)
	slli	t0, t1, 2
	sw	t0, 542(sp)
	lw	t1, 534(sp)
	lw	t2, 542(sp)
	add	t0, t1, t2
	sw	t0, 546(sp)
	li	t0, 2
	sw	t0, 550(sp)
	lw	t1, 546(sp)
	lw	t0, 550(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 554(sp)
	lw	t1, 554(sp)
	lw	t0, 0(t1)
	sw	t0, 558(sp)
	li	t0, 6
	sw	t0, 562(sp)
	lw	t1, 562(sp)
	slli	t0, t1, 2
	sw	t0, 566(sp)
	lw	t1, 558(sp)
	lw	t2, 566(sp)
	add	t0, t1, t2
	sw	t0, 570(sp)
	li	t0, 1
	sw	t0, 574(sp)
	lw	t1, 570(sp)
	lw	t0, 574(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 578(sp)
	lw	t1, 578(sp)
	lw	t0, 0(t1)
	sw	t0, 582(sp)
	li	t0, 6
	sw	t0, 586(sp)
	lw	t1, 586(sp)
	slli	t0, t1, 2
	sw	t0, 590(sp)
	lw	t1, 582(sp)
	lw	t2, 590(sp)
	add	t0, t1, t2
	sw	t0, 594(sp)
	li	t0, 0
	sw	t0, 598(sp)
	li	t0, 2
	sw	t0, 602(sp)
	lw	t1, 598(sp)
	lw	t2, 602(sp)
	sub	t0, t1, t2
	sw	t0, 606(sp)
	lw	t1, 594(sp)
	lw	t0, 606(sp)
	sw	t0, 0(t1)
	la	t0, @dx
	sw	t0, 610(sp)
	lw	t1, 610(sp)
	lw	t0, 0(t1)
	sw	t0, 614(sp)
	li	t0, 7
	sw	t0, 618(sp)
	lw	t1, 618(sp)
	slli	t0, t1, 2
	sw	t0, 622(sp)
	lw	t1, 614(sp)
	lw	t2, 622(sp)
	add	t0, t1, t2
	sw	t0, 626(sp)
	li	t0, 1
	sw	t0, 630(sp)
	lw	t1, 626(sp)
	lw	t0, 630(sp)
	sw	t0, 0(t1)
	la	t0, @dy
	sw	t0, 634(sp)
	lw	t1, 634(sp)
	lw	t0, 0(t1)
	sw	t0, 638(sp)
	li	t0, 7
	sw	t0, 642(sp)
	lw	t1, 642(sp)
	slli	t0, t1, 2
	sw	t0, 646(sp)
	lw	t1, 638(sp)
	lw	t2, 646(sp)
	add	t0, t1, t2
	sw	t0, 650(sp)
	li	t0, 2
	sw	t0, 654(sp)
	lw	t1, 650(sp)
	lw	t0, 654(sp)
	sw	t0, 0(t1)
	j	.Lwhile.cond_0

.Lwhile.cond_0:
	la	t0, @head
	sw	t0, 658(sp)
	lw	t1, 658(sp)
	lw	t0, 0(t1)
	sw	t0, 662(sp)
	la	t0, @tail
	sw	t0, 666(sp)
	lw	t1, 666(sp)
	lw	t0, 0(t1)
	sw	t0, 670(sp)
	lw	t1, 670(sp)
	lw	t2, 662(sp)
	slt	t0, t1, t2
	sw	t0, 674(sp)
	lw	t1, 674(sp)
	xori	t0, t1, 1
	sb	t0, 678(sp)
	lb	t1, 678(sp)
	beqz	t1, .Lwhile.end_0
	j	.Lwhile.body_0

.Lwhile.body_0:
	la	t0, @xlist
	sw	t0, 679(sp)
	lw	t1, 679(sp)
	lw	t0, 0(t1)
	sw	t0, 683(sp)
	la	t0, @head
	sw	t0, 687(sp)
	lw	t1, 687(sp)
	lw	t0, 0(t1)
	sw	t0, 691(sp)
	lw	t1, 691(sp)
	slli	t0, t1, 2
	sw	t0, 695(sp)
	lw	t1, 683(sp)
	lw	t2, 695(sp)
	add	t0, t1, t2
	sw	t0, 699(sp)
	lw	t1, 699(sp)
	lw	t0, 0(t1)
	sw	t0, 703(sp)
	la	t0, @x
	sw	t0, 707(sp)
	lw	t1, 707(sp)
	lw	t0, 703(sp)
	sw	t0, 0(t1)
	la	t0, @ylist
	sw	t0, 711(sp)
	lw	t1, 711(sp)
	lw	t0, 0(t1)
	sw	t0, 715(sp)
	la	t0, @head
	sw	t0, 719(sp)
	lw	t1, 719(sp)
	lw	t0, 0(t1)
	sw	t0, 723(sp)
	lw	t1, 723(sp)
	slli	t0, t1, 2
	sw	t0, 727(sp)
	lw	t1, 715(sp)
	lw	t2, 727(sp)
	add	t0, t1, t2
	sw	t0, 731(sp)
	lw	t1, 731(sp)
	lw	t0, 0(t1)
	sw	t0, 735(sp)
	la	t0, @y
	sw	t0, 739(sp)
	lw	t1, 739(sp)
	lw	t0, 735(sp)
	sw	t0, 0(t1)
	la	t0, @step
	sw	t0, 743(sp)
	lw	t1, 743(sp)
	lw	t0, 0(t1)
	sw	t0, 747(sp)
	la	t0, @x
	sw	t0, 751(sp)
	lw	t1, 751(sp)
	lw	t0, 0(t1)
	sw	t0, 755(sp)
	lw	t1, 755(sp)
	slli	t0, t1, 2
	sw	t0, 759(sp)
	lw	t1, 747(sp)
	lw	t2, 759(sp)
	add	t0, t1, t2
	sw	t0, 763(sp)
	lw	t1, 763(sp)
	lw	t0, 0(t1)
	sw	t0, 767(sp)
	la	t0, @y
	sw	t0, 771(sp)
	lw	t1, 771(sp)
	lw	t0, 0(t1)
	sw	t0, 775(sp)
	lw	t1, 775(sp)
	slli	t0, t1, 2
	sw	t0, 779(sp)
	lw	t1, 767(sp)
	lw	t2, 779(sp)
	add	t0, t1, t2
	sw	t0, 783(sp)
	lw	t1, 783(sp)
	lw	t0, 0(t1)
	sw	t0, 787(sp)
	la	t0, @now
	sw	t0, 791(sp)
	lw	t1, 791(sp)
	lw	t0, 787(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 795(sp)
	la	t0, @j
	sw	t0, 799(sp)
	lw	t1, 799(sp)
	lw	t0, 795(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_4

.Lfor.cond_4:
	la	t0, @j
	sw	t0, 803(sp)
	lw	t1, 803(sp)
	lw	t0, 0(t1)
	sw	t0, 807(sp)
	li	t0, 8
	sw	t0, 811(sp)
	lw	t1, 807(sp)
	lw	t2, 811(sp)
	slt	t0, t1, t2
	sb	t0, 815(sp)
	lb	t1, 815(sp)
	beqz	t1, .Lfor.end_4
	j	.Lfor.body_4

.Lfor.inc_4:
	la	t0, @j
	sw	t0, 816(sp)
	lw	t1, 816(sp)
	lw	t0, 0(t1)
	sw	t0, 820(sp)
	li	t0, 1
	sw	t0, 824(sp)
	lw	t1, 820(sp)
	lw	t2, 824(sp)
	add	t0, t1, t2
	sw	t0, 828(sp)
	la	t0, @j
	sw	t0, 832(sp)
	lw	t1, 832(sp)
	lw	t0, 828(sp)
	sw	t0, 0(t1)
	j	.Lfor.cond_4

.Lfor.body_4:
	la	t0, @dx
	sw	t0, 836(sp)
	lw	t1, 836(sp)
	lw	t0, 0(t1)
	sw	t0, 840(sp)
	la	t0, @j
	sw	t0, 844(sp)
	lw	t1, 844(sp)
	lw	t0, 0(t1)
	sw	t0, 848(sp)
	lw	t1, 848(sp)
	slli	t0, t1, 2
	sw	t0, 852(sp)
	lw	t1, 840(sp)
	lw	t2, 852(sp)
	add	t0, t1, t2
	sw	t0, 856(sp)
	la	t0, @x
	sw	t0, 860(sp)
	lw	t1, 860(sp)
	lw	t0, 0(t1)
	sw	t0, 864(sp)
	lw	t1, 856(sp)
	lw	t0, 0(t1)
	sw	t0, 868(sp)
	lw	t1, 864(sp)
	lw	t2, 868(sp)
	add	t0, t1, t2
	sw	t0, 872(sp)
	la	t0, @dy
	sw	t0, 876(sp)
	lw	t1, 876(sp)
	lw	t0, 0(t1)
	sw	t0, 880(sp)
	la	t0, @j
	sw	t0, 884(sp)
	lw	t1, 884(sp)
	lw	t0, 0(t1)
	sw	t0, 888(sp)
	lw	t1, 888(sp)
	slli	t0, t1, 2
	sw	t0, 892(sp)
	lw	t1, 880(sp)
	lw	t2, 892(sp)
	add	t0, t1, t2
	sw	t0, 896(sp)
	la	t0, @y
	sw	t0, 900(sp)
	lw	t1, 900(sp)
	lw	t0, 0(t1)
	sw	t0, 904(sp)
	lw	t1, 896(sp)
	lw	t0, 0(t1)
	sw	t0, 908(sp)
	lw	t1, 904(sp)
	lw	t2, 908(sp)
	add	t0, t1, t2
	sw	t0, 912(sp)
	lw	t1, 872(sp)
	mv	a0, t1
	lw	t1, 912(sp)
	mv	a1, t1
	call	addList
	mv	t0, a0
	sb	t0, 916(sp)
	j	.Lfor.inc_4

.Lfor.end_4:
	la	t0, @ok
	sw	t0, 916(sp)
	lw	t1, 916(sp)
	lw	t0, 0(t1)
	sw	t0, 920(sp)
	li	t0, 1
	sw	t0, 924(sp)
	lw	t1, 920(sp)
	lw	t2, 924(sp)
	sub	t0, t1, t2
	sw	t0, 928(sp)
	lw	t1, 928(sp)
	seqz	t0, t1
	sb	t0, 932(sp)
	lb	t1, 932(sp)
	beqz	t1, .Lif.end_2
	j	.Lif.then_2

.Lif.then_2:
	j	.Lwhile.end_0

.Lif.end_2:
	la	t0, @head
	sw	t0, 933(sp)
	lw	t1, 933(sp)
	lw	t0, 0(t1)
	sw	t0, 937(sp)
	li	t0, 1
	sw	t0, 941(sp)
	lw	t1, 937(sp)
	lw	t2, 941(sp)
	add	t0, t1, t2
	sw	t0, 945(sp)
	la	t0, @head
	sw	t0, 949(sp)
	lw	t1, 949(sp)
	lw	t0, 945(sp)
	sw	t0, 0(t1)
	j	.Lwhile.cond_0

.Lwhile.end_0:
	la	t0, @ok
	sw	t0, 953(sp)
	lw	t1, 953(sp)
	lw	t0, 0(t1)
	sw	t0, 957(sp)
	li	t0, 1
	sw	t0, 961(sp)
	lw	t1, 957(sp)
	lw	t2, 961(sp)
	sub	t0, t1, t2
	sw	t0, 965(sp)
	lw	t1, 965(sp)
	seqz	t0, t1
	sb	t0, 969(sp)
	lb	t1, 969(sp)
	beqz	t1, .Lif.else_3
	j	.Lif.then_3

.Lif.then_3:
	la	t0, @step
	sw	t0, 970(sp)
	lw	t1, 970(sp)
	lw	t0, 0(t1)
	sw	t0, 974(sp)
	la	t0, @targetx
	sw	t0, 978(sp)
	lw	t1, 978(sp)
	lw	t0, 0(t1)
	sw	t0, 982(sp)
	lw	t1, 982(sp)
	slli	t0, t1, 2
	sw	t0, 986(sp)
	lw	t1, 974(sp)
	lw	t2, 986(sp)
	add	t0, t1, t2
	sw	t0, 990(sp)
	lw	t1, 990(sp)
	lw	t0, 0(t1)
	sw	t0, 994(sp)
	la	t0, @targety
	sw	t0, 998(sp)
	lw	t1, 998(sp)
	lw	t0, 0(t1)
	sw	t0, 1002(sp)
	lw	t1, 1002(sp)
	slli	t0, t1, 2
	sw	t0, 1006(sp)
	lw	t1, 994(sp)
	lw	t2, 1006(sp)
	add	t0, t1, t2
	sw	t0, 1010(sp)
	lw	t1, 1010(sp)
	lw	t0, 0(t1)
	sw	t0, 1014(sp)
	lw	t1, 1014(sp)
	mv	a0, t1
	call	toString
	mv	t0, a0
	sw	t0, 1018(sp)
	lw	t1, 1018(sp)
	mv	a0, t1
	call	println
	mv	t0, a0
	sb	t0, 1022(sp)
	j	.Lif.end_3

.Lif.else_3:
	la	t0, .str.0
	sw	t0, 1022(sp)
	lw	t1, 1022(sp)
	mv	a0, t1
	call	print
	mv	t0, a0
	sb	t0, 1026(sp)
	j	.Lif.end_3

.Lif.end_3:
	li	t0, 0
	sw	t0, 1026(sp)
	lw	t1, 12(sp)
	lw	t0, 1026(sp)
	sw	t0, 0(t1)
	j	.Lexit_main_0

.Lexit_main_0:
	lw	t1, 12(sp)
	lw	t0, 0(t1)
	sw	t0, 1030(sp)
	lw	t1, 1030(sp)
	mv	a0, t1
	lw	ra, 0(sp)
	addi	sp, sp, 1068
	ret


	.text
	.globl	__mx_global_var_init
__mx_global_var_init:
.Lenter___mx_global_var_init_0:
	addi	sp, sp, -180
	sw	ra, 0(sp)
	li	t0, 12000
	sw	t0, 4(sp)
	li	t0, 4
	sw	t0, 8(sp)
	lw	t1, 4(sp)
	lw	t2, 8(sp)
	mul	t0, t1, t2
	sw	t0, 12(sp)
	li	t0, 4
	sw	t0, 16(sp)
	lw	t1, 12(sp)
	lw	t2, 16(sp)
	add	t0, t1, t2
	sw	t0, 20(sp)
	lw	t1, 20(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 24(sp)
	li	t0, 12000
	sw	t0, 28(sp)
	lw	t1, 24(sp)
	lw	t0, 28(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 32(sp)
	lw	t1, 32(sp)
	slli	t0, t1, 2
	sw	t0, 36(sp)
	lw	t1, 24(sp)
	lw	t2, 36(sp)
	add	t0, t1, t2
	sw	t0, 40(sp)
	la	t0, @xlist
	sw	t0, 44(sp)
	lw	t1, 44(sp)
	lw	t0, 40(sp)
	sw	t0, 0(t1)
	li	t0, 12000
	sw	t0, 48(sp)
	li	t0, 4
	sw	t0, 52(sp)
	lw	t1, 48(sp)
	lw	t2, 52(sp)
	mul	t0, t1, t2
	sw	t0, 56(sp)
	li	t0, 4
	sw	t0, 60(sp)
	lw	t1, 56(sp)
	lw	t2, 60(sp)
	add	t0, t1, t2
	sw	t0, 64(sp)
	lw	t1, 64(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 68(sp)
	li	t0, 12000
	sw	t0, 72(sp)
	lw	t1, 68(sp)
	lw	t0, 72(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 76(sp)
	lw	t1, 76(sp)
	slli	t0, t1, 2
	sw	t0, 80(sp)
	lw	t1, 68(sp)
	lw	t2, 80(sp)
	add	t0, t1, t2
	sw	t0, 84(sp)
	la	t0, @ylist
	sw	t0, 88(sp)
	lw	t1, 88(sp)
	lw	t0, 84(sp)
	sw	t0, 0(t1)
	li	t0, 8
	sw	t0, 92(sp)
	li	t0, 4
	sw	t0, 96(sp)
	lw	t1, 92(sp)
	lw	t2, 96(sp)
	mul	t0, t1, t2
	sw	t0, 100(sp)
	li	t0, 4
	sw	t0, 104(sp)
	lw	t1, 100(sp)
	lw	t2, 104(sp)
	add	t0, t1, t2
	sw	t0, 108(sp)
	lw	t1, 108(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 112(sp)
	li	t0, 8
	sw	t0, 116(sp)
	lw	t1, 112(sp)
	lw	t0, 116(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 120(sp)
	lw	t1, 120(sp)
	slli	t0, t1, 2
	sw	t0, 124(sp)
	lw	t1, 112(sp)
	lw	t2, 124(sp)
	add	t0, t1, t2
	sw	t0, 128(sp)
	la	t0, @dx
	sw	t0, 132(sp)
	lw	t1, 132(sp)
	lw	t0, 128(sp)
	sw	t0, 0(t1)
	li	t0, 9
	sw	t0, 136(sp)
	li	t0, 4
	sw	t0, 140(sp)
	lw	t1, 136(sp)
	lw	t2, 140(sp)
	mul	t0, t1, t2
	sw	t0, 144(sp)
	li	t0, 4
	sw	t0, 148(sp)
	lw	t1, 144(sp)
	lw	t2, 148(sp)
	add	t0, t1, t2
	sw	t0, 152(sp)
	lw	t1, 152(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 156(sp)
	li	t0, 9
	sw	t0, 160(sp)
	lw	t1, 156(sp)
	lw	t0, 160(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 164(sp)
	lw	t1, 164(sp)
	slli	t0, t1, 2
	sw	t0, 168(sp)
	lw	t1, 156(sp)
	lw	t2, 168(sp)
	add	t0, t1, t2
	sw	t0, 172(sp)
	la	t0, @dy
	sw	t0, 176(sp)
	lw	t1, 176(sp)
	lw	t0, 172(sp)
	sw	t0, 0(t1)
	j	.Lexit___mx_global_var_init_0

.Lexit___mx_global_var_init_0:
	lw	ra, 0(sp)
	addi	sp, sp, 180
	ret



