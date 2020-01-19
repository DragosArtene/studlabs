//
//  LoginViewController.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    lazy private var presenter: LoginPresenter = LoginPresenter(view: self, navigation: self)
    
    @IBOutlet weak var backgroundView: UIView!
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var loginButton: UIButton!
    @IBAction func loginButtonAction(_ sender: Any) {
        presenter.loginPressed()
    }
    @IBAction func registerButtonAction(_ sender: Any) {
        presenter.registerPressed()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
        self.navigationController?.navigationBar.isHidden = true
        setGradientBackground()
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesBegan(touches, with: event)
        
        emailTextField.endEditing(true)
        passwordTextField.endEditing(true)
    }
    
    private func setGradientBackground() {
        let gradientLayer = CAGradientLayer()
        gradientLayer.colors = [Color.colorDark.cgColor, Color.colorPrimary.cgColor]
        gradientLayer.locations = [0.0, 1.0]
        gradientLayer.frame = self.view.bounds

        self.backgroundView.layer.insertSublayer(gradientLayer, at:0)
    }
}

extension LoginViewController: LoginView {
    
}

extension LoginViewController: LoginNavigation {
    func navigateToRegister() {
        guard let viewController = UIStoryboard(name: "Register", bundle: nil).instantiateInitialViewController() as? RegisterViewController else { return }
        let presenter: RegisterPresenter = RegisterPresenter(view: viewController, navigation: viewController)
        viewController.presenter = presenter
        self.navigationController?.pushViewController(viewController, animated: true)
    }
    
    func navigateToHome() {
        guard let viewController = UIStoryboard(name: "Home", bundle: nil).instantiateInitialViewController() as? HomeViewController else { return }
        self.navigationController?.pushViewController(viewController, animated: true)
    }
    
    private func addScreen(of viewController: UIViewController) {
        addChild(viewController)
        viewController.view.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(viewController.view)
        viewController.view.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        viewController.view.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        viewController.view.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        viewController.view.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
    }
}
