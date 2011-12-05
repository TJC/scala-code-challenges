FSC=fsc -max-idle 30 -deprecation

all: net/dryft/gchq/vmemu.class

net/dryft/gchq/vmemu.class: vm.scala
	$(FSC) vm.scala

run: net/dryft/gchq/vmemu.class
	scala net.dryft.gchq.vmemu
