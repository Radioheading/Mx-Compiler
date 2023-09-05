	.section .rodata
.str.0:
.asciz	"\n"
	.text
	.globl	main
main:
.LBBenter_main_0:
	addi	sp, sp, -588
	sw	ra, 0(sp)
	li	t0, 4
	sw	t0, 36(sp)
	lw	t2, 36(sp)
	add	t0, sp, t2
	sw	t0, 40(sp)
	li	t0, 8
	sw	t0, 44(sp)
	lw	t2, 44(sp)
	add	t0, sp, t2
	sw	t0, 48(sp)
	li	t0, 12
	sw	t0, 52(sp)
	lw	t2, 52(sp)
	add	t0, sp, t2
	sw	t0, 56(sp)
	li	t0, 16
	sw	t0, 60(sp)
	lw	t2, 60(sp)
	add	t0, sp, t2
	sw	t0, 64(sp)
	li	t0, 20
	sw	t0, 68(sp)
	lw	t2, 68(sp)
	add	t0, sp, t2
	sw	t0, 72(sp)
	li	t0, 24
	sw	t0, 76(sp)
	lw	t2, 76(sp)
	add	t0, sp, t2
	sw	t0, 80(sp)
	li	t0, 28
	sw	t0, 84(sp)
	lw	t2, 84(sp)
	add	t0, sp, t2
	sw	t0, 88(sp)
	li	t0, 32
	sw	t0, 92(sp)
	lw	t2, 92(sp)
	add	t0, sp, t2
	sw	t0, 96(sp)
	li	t0, 0
	sw	t0, 100(sp)
	lw	t1, 96(sp)
	lw	t0, 100(sp)
	sw	t0, 0(t1)
	li	t0, 10000
	sw	t0, 104(sp)
	lw	t1, 88(sp)
	lw	t0, 104(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 108(sp)
	lw	t1, 80(sp)
	lw	t0, 108(sp)
	sw	t0, 0(t1)
	li	t0, 2800
	sw	t0, 112(sp)
	lw	t1, 72(sp)
	lw	t0, 112(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 116(sp)
	lw	t1, 64(sp)
	lw	t0, 116(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 120(sp)
	lw	t1, 56(sp)
	lw	t0, 120(sp)
	sw	t0, 0(t1)
	li	t0, 2801
	sw	t0, 124(sp)
	li	t0, 4
	sw	t0, 128(sp)
	lw	t1, 124(sp)
	lw	t2, 128(sp)
	mul	t0, t1, t2
	sw	t0, 132(sp)
	li	t0, 4
	sw	t0, 136(sp)
	lw	t1, 132(sp)
	lw	t2, 136(sp)
	add	t0, t1, t2
	sw	t0, 140(sp)
	lw	t1, 140(sp)
	mv	a0, t1
	call	__malloc
	mv	t0, a0
	sw	t0, 144(sp)
	li	t0, 2801
	sw	t0, 148(sp)
	lw	t1, 144(sp)
	lw	t0, 148(sp)
	sw	t0, 0(t1)
	li	t0, 1
	sw	t0, 152(sp)
	lw	t1, 152(sp)
	slli	t0, t1, 2
	sw	t0, 156(sp)
	lw	t1, 144(sp)
	lw	t2, 156(sp)
	add	t0, t1, t2
	sw	t0, 160(sp)
	lw	t1, 48(sp)
	lw	t0, 160(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 164(sp)
	lw	t1, 40(sp)
	lw	t0, 164(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 168(sp)
	j	.LBBfor.cond_0

.LBBfor.cond_0:
	lw	t1, 168(sp)
	mv	t0, t1
	sw	t0, 172(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 176(sp)
	lw	t1, 72(sp)
	lw	t0, 0(t1)
	sw	t0, 180(sp)
	li	t0, 2800
	sw	t0, 184(sp)
	lw	t1, 172(sp)
	lw	t2, 184(sp)
	sub	t0, t1, t2
	sw	t0, 188(sp)
	li	t0, 0
	sw	t0, 192(sp)
	lw	t1, 188(sp)
	lw	t2, 192(sp)
	sub	t0, t1, t2
	sw	t0, 196(sp)
	lw	t1, 196(sp)
	snez	t0, t1
	sb	t0, 200(sp)
	lb	t1, 200(sp)
	beqz	t1, .LBBfor.end_0
	j	.LBBfor.body_0

.LBBfor.inc_0:
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 201(sp)
	li	t0, 1
	sw	t0, 205(sp)
	lw	t1, 172(sp)
	lw	t2, 205(sp)
	add	t0, t1, t2
	sw	t0, 209(sp)
	lw	t1, 80(sp)
	lw	t0, 209(sp)
	sw	t0, 0(t1)
	lw	t1, 209(sp)
	mv	t0, t1
	sw	t0, 168(sp)
	j	.LBBfor.cond_0

.LBBfor.body_0:
	lw	t1, 48(sp)
	lw	t0, 0(t1)
	sw	t0, 213(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 217(sp)
	lw	t1, 172(sp)
	slli	t0, t1, 2
	sw	t0, 221(sp)
	lw	t1, 160(sp)
	lw	t2, 221(sp)
	add	t0, t1, t2
	sw	t0, 225(sp)
	lw	t1, 88(sp)
	lw	t0, 0(t1)
	sw	t0, 229(sp)
	li	t0, 10000
	sw	t0, 233(sp)
	li	t0, 5
	sw	t0, 237(sp)
	lw	t1, 233(sp)
	lw	t2, 237(sp)
	div	t0, t1, t2
	sw	t0, 241(sp)
	lw	t1, 225(sp)
	lw	t0, 241(sp)
	sw	t0, 0(t1)
	j	.LBBfor.inc_0

.LBBfor.end_0:
	lw	t1, 172(sp)
	mv	t0, t1
	sw	t0, 245(sp)
	li	t0, 2800
	sw	t0, 249(sp)
	li	t0, 0
	sw	t0, 253(sp)
	li	t0, 0
	sw	t0, 257(sp)
	li	t0, 0
	sw	t0, 261(sp)
	j	.LBBfor.cond_1

.LBBfor.cond_1:
	lw	t1, 261(sp)
	mv	t0, t1
	sw	t0, 265(sp)
	lw	t1, 257(sp)
	mv	t0, t1
	sw	t0, 269(sp)
	lw	t1, 253(sp)
	mv	t0, t1
	sw	t0, 273(sp)
	lw	t1, 249(sp)
	mv	t0, t1
	sw	t0, 277(sp)
	lw	t1, 245(sp)
	mv	t0, t1
	sw	t0, 281(sp)
	j	.LBBfor.body_1

.LBBfor.inc_1:
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 285(sp)
	lw	t1, 88(sp)
	lw	t0, 0(t1)
	sw	t0, 289(sp)
	li	t0, 10000
	sw	t0, 293(sp)
	lw	t1, 297(sp)
	lw	t2, 293(sp)
	rem	t0, t1, t2
	sw	t0, 301(sp)
	lw	t1, 56(sp)
	lw	t0, 301(sp)
	sw	t0, 0(t1)
	lw	t1, 305(sp)
	mv	t0, t1
	sw	t0, 245(sp)
	lw	t1, 309(sp)
	mv	t0, t1
	sw	t0, 249(sp)
	lw	t1, 313(sp)
	mv	t0, t1
	sw	t0, 253(sp)
	lw	t1, 317(sp)
	mv	t0, t1
	sw	t0, 257(sp)
	lw	t1, 301(sp)
	mv	t0, t1
	sw	t0, 261(sp)
	j	.LBBfor.cond_1

.LBBfor.body_1:
	li	t0, 0
	sw	t0, 321(sp)
	lw	t1, 64(sp)
	lw	t0, 321(sp)
	sw	t0, 0(t1)
	lw	t1, 72(sp)
	lw	t0, 0(t1)
	sw	t0, 325(sp)
	li	t0, 2
	sw	t0, 329(sp)
	lw	t1, 277(sp)
	lw	t2, 329(sp)
	mul	t0, t1, t2
	sw	t0, 333(sp)
	lw	t1, 40(sp)
	lw	t0, 333(sp)
	sw	t0, 0(t1)
	lw	t1, 40(sp)
	lw	t0, 0(t1)
	sw	t0, 337(sp)
	li	t0, 0
	sw	t0, 341(sp)
	lw	t1, 333(sp)
	lw	t2, 341(sp)
	sub	t0, t1, t2
	sw	t0, 345(sp)
	lw	t1, 345(sp)
	seqz	t0, t1
	sb	t0, 349(sp)
	lb	t1, 349(sp)
	beqz	t1, .LBBif.end_0
	j	.LBBif.then_0

.LBBif.then_0:
	j	.LBBfor.end_1

.LBBif.end_0:
	lw	t1, 72(sp)
	lw	t0, 0(t1)
	sw	t0, 350(sp)
	lw	t1, 80(sp)
	lw	t0, 277(sp)
	sw	t0, 0(t1)
	lw	t1, 277(sp)
	mv	t0, t1
	sw	t0, 354(sp)
	lw	t1, 333(sp)
	mv	t0, t1
	sw	t0, 358(sp)
	li	t0, 0
	sw	t0, 362(sp)
	j	.LBBfor.cond_2

.LBBfor.cond_2:
	lw	t1, 362(sp)
	mv	t0, t1
	sw	t0, 366(sp)
	lw	t1, 358(sp)
	mv	t0, t1
	sw	t0, 370(sp)
	lw	t1, 354(sp)
	mv	t0, t1
	sw	t0, 374(sp)
	j	.LBBfor.body_2

.LBBfor.inc_2:
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 378(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 382(sp)
	lw	t1, 317(sp)
	lw	t2, 305(sp)
	mul	t0, t1, t2
	sw	t0, 386(sp)
	lw	t1, 64(sp)
	lw	t0, 386(sp)
	sw	t0, 0(t1)
	lw	t1, 305(sp)
	mv	t0, t1
	sw	t0, 354(sp)
	lw	t1, 313(sp)
	mv	t0, t1
	sw	t0, 358(sp)
	lw	t1, 386(sp)
	mv	t0, t1
	sw	t0, 362(sp)
	j	.LBBfor.cond_2

.LBBfor.body_2:
	lw	t1, 48(sp)
	lw	t0, 0(t1)
	sw	t0, 390(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 394(sp)
	lw	t1, 374(sp)
	slli	t0, t1, 2
	sw	t0, 398(sp)
	lw	t1, 160(sp)
	lw	t2, 398(sp)
	add	t0, t1, t2
	sw	t0, 402(sp)
	lw	t1, 402(sp)
	lw	t0, 0(t1)
	sw	t0, 406(sp)
	lw	t1, 88(sp)
	lw	t0, 0(t1)
	sw	t0, 410(sp)
	li	t0, 10000
	sw	t0, 414(sp)
	lw	t1, 406(sp)
	lw	t2, 414(sp)
	mul	t0, t1, t2
	sw	t0, 418(sp)
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 422(sp)
	lw	t1, 366(sp)
	lw	t2, 418(sp)
	add	t0, t1, t2
	sw	t0, 426(sp)
	lw	t1, 64(sp)
	lw	t0, 426(sp)
	sw	t0, 0(t1)
	lw	t1, 48(sp)
	lw	t0, 0(t1)
	sw	t0, 430(sp)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 434(sp)
	lw	t1, 374(sp)
	slli	t0, t1, 2
	sw	t0, 438(sp)
	lw	t1, 160(sp)
	lw	t2, 438(sp)
	add	t0, t1, t2
	sw	t0, 442(sp)
	lw	t1, 40(sp)
	lw	t0, 0(t1)
	sw	t0, 446(sp)
	li	t0, 1
	sw	t0, 450(sp)
	lw	t1, 370(sp)
	lw	t2, 450(sp)
	sub	t0, t1, t2
	sw	t0, 454(sp)
	lw	t1, 40(sp)
	lw	t0, 454(sp)
	sw	t0, 0(t1)
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 458(sp)
	lw	t1, 426(sp)
	lw	t2, 454(sp)
	rem	t0, t1, t2
	sw	t0, 462(sp)
	lw	t1, 442(sp)
	lw	t0, 462(sp)
	sw	t0, 0(t1)
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 466(sp)
	lw	t1, 40(sp)
	lw	t0, 0(t1)
	sw	t0, 470(sp)
	lw	t1, 426(sp)
	lw	t2, 454(sp)
	div	t0, t1, t2
	sw	t0, 317(sp)
	lw	t1, 64(sp)
	lw	t0, 317(sp)
	sw	t0, 0(t1)
	lw	t1, 40(sp)
	lw	t0, 0(t1)
	sw	t0, 474(sp)
	li	t0, 1
	sw	t0, 478(sp)
	lw	t1, 454(sp)
	lw	t2, 478(sp)
	sub	t0, t1, t2
	sw	t0, 313(sp)
	lw	t1, 40(sp)
	lw	t0, 313(sp)
	sw	t0, 0(t1)
	lw	t1, 80(sp)
	lw	t0, 0(t1)
	sw	t0, 482(sp)
	li	t0, 1
	sw	t0, 486(sp)
	lw	t1, 374(sp)
	lw	t2, 486(sp)
	sub	t0, t1, t2
	sw	t0, 305(sp)
	lw	t1, 80(sp)
	lw	t0, 305(sp)
	sw	t0, 0(t1)
	li	t0, 0
	sw	t0, 490(sp)
	lw	t1, 305(sp)
	lw	t2, 490(sp)
	sub	t0, t1, t2
	sw	t0, 494(sp)
	lw	t1, 494(sp)
	seqz	t0, t1
	sb	t0, 498(sp)
	lb	t1, 498(sp)
	beqz	t1, .LBBif.end_1
	j	.LBBif.then_1

.LBBif.then_1:
	j	.LBBfor.end_2

.LBBif.end_1:
	j	.LBBfor.inc_2

.LBBfor.end_2:
	lw	t1, 72(sp)
	lw	t0, 0(t1)
	sw	t0, 499(sp)
	li	t0, 14
	sw	t0, 503(sp)
	lw	t1, 277(sp)
	lw	t2, 503(sp)
	sub	t0, t1, t2
	sw	t0, 309(sp)
	lw	t1, 72(sp)
	lw	t0, 309(sp)
	sw	t0, 0(t1)
	lw	t1, 64(sp)
	lw	t0, 0(t1)
	sw	t0, 507(sp)
	lw	t1, 88(sp)
	lw	t0, 0(t1)
	sw	t0, 511(sp)
	li	t0, 10000
	sw	t0, 515(sp)
	lw	t1, 317(sp)
	lw	t2, 515(sp)
	div	t0, t1, t2
	sw	t0, 519(sp)
	lw	t1, 56(sp)
	lw	t0, 0(t1)
	sw	t0, 523(sp)
	lw	t1, 265(sp)
	lw	t2, 519(sp)
	add	t0, t1, t2
	sw	t0, 527(sp)
	lw	t1, 527(sp)
	mv	a0, t1
	call	toString
	mv	t0, a0
	sw	t0, 531(sp)
	lw	t1, 531(sp)
	mv	a0, t1
	call	print
	mv	t0, a0
	sb	t0, 535(sp)
	j	.LBBfor.inc_1

.LBBfor.end_1:
	la	t0, .str.0
	sw	t0, 535(sp)
	lw	t1, 535(sp)
	mv	a0, t1
	call	print
	mv	t0, a0
	sb	t0, 539(sp)
	li	t0, 0
	sw	t0, 539(sp)
	lw	t1, 96(sp)
	lw	t0, 539(sp)
	sw	t0, 0(t1)
	j	.LBBexit_main_0

.LBBexit_main_0:
	lw	t1, 96(sp)
	lw	t0, 0(t1)
	sw	t0, 543(sp)
	li	t0, 0
	sw	t0, 547(sp)
	lw	t1, 547(sp)
	mv	a0, t1
	lw	ra, 0(sp)
	addi	sp, sp, 588
	ret



