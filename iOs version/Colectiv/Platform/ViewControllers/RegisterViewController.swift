//
//  RegisterViewController.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class RegisterViewController: UIViewController {
    var presenter: RegisterPresenter?
    
    @IBOutlet weak var backgroundView: UIView!
    @IBOutlet weak var firstNameTextField: ColectivTextField!
    @IBOutlet weak var lastNameTextField: ColectivTextField!
    @IBOutlet weak var emailTextField: ColectivTextField!
    @IBOutlet weak var passwordTextField: ColectivTextField!
    @IBAction func registerButtonAction(_ sender: Any) {
        presenter?.registerPressed()
    }
    @IBAction func loginButtonAction(_ sender: Any) {
        presenter?.loginPressed()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setGradientBackground()
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesBegan(touches, with: event)
        
        emailTextField.endEditing(true)
        passwordTextField.endEditing(true)
        lastNameTextField.endEditing(true)
        firstNameTextField.endEditing(true)
    }
    
    private func setGradientBackground() {
        let gradientLayer = CAGradientLayer()
        gradientLayer.colors = [Color.colorDark.cgColor, Color.colorPrimary.cgColor]
        gradientLayer.locations = [0.0, 1.0]
        gradientLayer.frame = self.view.bounds

        self.backgroundView.layer.insertSublayer(gradientLayer, at:0)
    }
}

extension RegisterViewController: RegisterView {
    
}

extension RegisterViewController: RegisterNavigation {
    func navigateToLogin() {
        self.navigationController?.popViewController(animated: true)
    }
}
