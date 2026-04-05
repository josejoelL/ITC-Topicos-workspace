package sistemabancario;


class SistemaBancario {
  private int saldo;

  public SistemaBancario(int saldo){
      this.saldo=saldo;
  }

    SistemaBancario() {
        this.saldo=0;
    }
  
    public void setSaldo(int saldo){
         this.saldo=saldo;
    }
    public int getSaldo(){
     return saldo;   
    }
}
