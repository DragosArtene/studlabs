//
//  RegisterPresenter.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class RegisterPresenter {
    private weak var view: RegisterView?
    private weak var navigation: RegisterNavigation?
    
    init(view: RegisterView, navigation: RegisterNavigation) {
        self.view = view
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        
    }
    
    func registerPressed() {
        navigation?.navigateToLogin()
    }
    
    func loginPressed() {
        navigation?.navigateToLogin()
    }
}
