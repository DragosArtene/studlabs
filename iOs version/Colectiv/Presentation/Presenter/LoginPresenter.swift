//
//  LoginPresenter.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class LoginPresenter {
    private weak var view: LoginView?
    private weak var navigation: LoginNavigation?
    private(set) var user: User? {
        get {
            guard let persistentValue = UserDefaults.standard.value(forKey: "user") as? Data,
                let user = try? JSONDecoder().decode(User.self, from: persistentValue) else {
                    return nil
            }
            return user
        }
        
        set {
            let data = try? JSONEncoder().encode(newValue)
            UserDefaults.standard.set(data, forKey: "user")
        }
    }
    
    init(view: LoginView, navigation: LoginNavigation) {
        self.view = view
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        let usr: User = User(firstName: "Andrei", lastName: "Lobont", email: "", completezQuizes: user?.completezQuizes ?? [])
        user = usr
    }
    
    func loginPressed() {
        navigation?.navigateToHome()
        
    }
    
    func registerPressed() {
        navigation?.navigateToRegister()
    }
}
