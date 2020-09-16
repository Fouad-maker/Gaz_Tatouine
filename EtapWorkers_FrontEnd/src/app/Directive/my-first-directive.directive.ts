import { Directive, HostListener } from '@angular/core';
import { Router } from '@angular/router';

@Directive({
  selector: '[appMyFirstDirective]'
})
export class MyFirstDirectiveDirective {

  constructor(private router:Router) { }

  @HostListener('mouseenter') onMouseEnter(){
    this.router.navigateByUrl('main-interface');



  }

  @HostListener('mouseleave') onMouseLeave() {
    this.router.navigateByUrl('admin');
  }

}
